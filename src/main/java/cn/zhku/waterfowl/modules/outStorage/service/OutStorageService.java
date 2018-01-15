package cn.zhku.waterfowl.modules.outStorage.service;

import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.entity.OutstorageExample;
import cn.zhku.waterfowl.pojo.mapper.OutstorageMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import cn.zhku.waterfowl.util.modle.CommonQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.ScreenUpdateManager;

import java.util.*;

@Service
public class OutStorageService  implements IBaseService<Outstorage> {
    @Autowired
    private OutstorageMapper outstorageMapper;
    @Autowired
    private OutStorageDao outStorageDao;

    /**
     * 根据outstorage实体插入
     */
    @Override
    public int add(Outstorage entity) throws Exception {
        return outstorageMapper.insert(entity);
    }

    @Override
    /**
     * 根据outstorage实体更新
     * @param entity 映射数据库单表的实体类
     * @return
     */
    public int update(Outstorage entity) throws Exception {
        return outstorageMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    /**
     *根据outstorage实体类id删除
     * @param entity 映射数据库单表的实体类
     * @return
     */
    public int delete(Outstorage entity) throws Exception {

        return outstorageMapper.deleteByPrimaryKey(entity.getIdStorage());

    }

    @Override
    /**
     * 根据id得到epdemic实体类
     */
    public Outstorage get(String id) throws Exception {
        return outstorageMapper.selectByPrimaryKey(id);
    }

    @Override
    /**
     * 根据epdemic实体类的id查询
     */
    public Outstorage get(Outstorage entity) throws Exception {
        OutstorageExample outstorageExample =new OutstorageExample();
        outstorageExample.or().andIdOutstorageEqualTo(entity.getIdOutstorage());
        if (outstorageExample!=null) {
            return outstorageMapper.selectByExample(outstorageExample).get(0);
        }else {
            return null;
        }
    }

    @Override
    /**
     * 根据outstorage实体多条件查询
     */
    public List<Outstorage> findList(Outstorage entity) throws Exception {
        OutstorageExample outstorageExample =new OutstorageExample();
        OutstorageExample.Criteria criteria = outstorageExample.createCriteria();
        // 材料名称
        if (entity.getName()!=null)
            criteria.andNameLike("%"+entity.getName()+"%");
        //生产厂家
        if (entity.getRemark()!=null)
            criteria.andRemarkLike("%"+entity.getRemark()+"%");
        //库存编号
        if (entity.getIdStorage()!=null)
            criteria.andIdStorageEqualTo("%"+entity.getIdStorage()+"%");
        if (entity.getIdOutstorage()!=null)
            criteria.andIdOutstorageEqualTo("%"+entity.getIdOutstorage()+"%");
           //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //记录者编号
        if (entity.getIdRecorder()!=null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        return outstorageMapper.selectByExample(outstorageExample);
    }
    public List<Outstorage> showAll(Outstorage entity, CommonQo commonQo) {
        OutstorageExample outstorageExample =new OutstorageExample();
        OutstorageExample.Criteria criteria = outstorageExample.createCriteria();
        //  根据时间区间来查找
        if (commonQo.getStart() != null)
            criteria.andRecordDateGreaterThanOrEqualTo(commonQo.getStart());
        if (commonQo.getEnd() != null)
            criteria.andRecordDateLessThanOrEqualTo(commonQo.getEnd());
        return outstorageMapper.selectByExample(outstorageExample);
    }

    public List<Outstorage> listOutstorageByName(String name) throws Exception {
        //把listOutstorageByName返回的值放在ArrayList里面
        return outStorageDao.listOutstorageByName(name);
    }

    public String listType(String name,String firm,String remark) throws Exception {
        //把listOutstorageByName返回的值放在ArrayList里面
        List<Outstorage> outstoragelist=new ArrayList<Outstorage>(outStorageDao.listType(name,firm,remark));
        if (outstoragelist.isEmpty()){
            return null;
        }
        else{
        return outstoragelist.get(0).getType();}
    }

    //一个有效期的调度算法
    public void manageOutstorage(String name,String firm,float quantity) throws Exception {
        //把manageOutstorage返回的值放在ArrayList里面
        List<Outstorage> outstoragelist=new ArrayList<Outstorage>(outStorageDao.manageOutstorage(name,firm,quantity));
        //定义两个float变量sum，表示累加数;temp为定值float的0
        float sum=0;
        float temp=0;
        //开始进入循环体
        for (int i=0;i<outstoragelist.size();i++){
            //将每个记录的剩余量取出来
            float a=outstoragelist.get(i).getRest();
            //进行累加
            sum+=a;
            //如果累加的结果与所需要的量quantity相等
            if(sum==quantity) {
                //进行循环体
                for (int k=0;k<i;k++){
                    //将符合条件的记录取出来
                    Outstorage outstorage=outstoragelist.get(k);
                    //逐一将每一条记录的剩余量变为0
                    outstorage.setRest(temp);
                    //将更改后的记录放到数据库
                    outstorageMapper.updateByPrimaryKeySelective(outstorage);
                }
                //结束上一层循环体，即跳出循环
                break;
            }
            //如果累加的结果大于所需要的量quantity
            if(sum>quantity) {
                //将符合条件的但是仍有剩余量的记录取出来
                Outstorage less=outstoragelist.get(i);
                //改变该记录的剩余量
                less.setRest(sum-quantity);
                //将更改后的记录放到数据库
                outstorageMapper.updateByPrimaryKeySelective(less);
                //进行循环体
                for (int k=0;k<i-1;k++){
                    //将符合记录但是没有剩余量的记录取出来
                    Outstorage outstorage=outstoragelist.get(k);
                    //将这些记录的剩余量变为0
                    outstorage.setRest(temp);
                    //将更改后的记录放到数据库
                    outstorageMapper.updateByPrimaryKeySelective(outstorage);
                }
                //结束上一层循环体，即跳出循环
                break;
            }
        }

    }

}
