package cn.zhku.waterfowl.modules.outStorage.service;

import cn.zhku.waterfowl.modules.aquaStor.service.AquaStorService;
import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.pojo.entity.AquaStor;
import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.entity.OutstorageExample;
import cn.zhku.waterfowl.pojo.mapper.OutstorageMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OutStorageService  implements IBaseService<Outstorage> {
    @Autowired
    private OutstorageMapper outstorageMapper;
    @Autowired
    private OutStorageDao outStorageDao;
    @Autowired
    private AquaStorService aquaStorService;

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

        return outstorageMapper.deleteByPrimaryKey(entity.getIdOutstorage());

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
        if (entity.getIdOutstorage()!=null)
            criteria.andIdOutstorageEqualTo(entity.getIdOutstorage());
        if (entity.getType()!=null)
            criteria.andTypeEqualTo(entity.getType());
        if (entity.getValid()!=null)
            criteria.andValidEqualTo(entity.getValid());
        if (entity.getProvide()!=null)
            criteria.andProvideLike("%"+entity.getProvide()+"%");
        if (entity.getPhone()!=null)
            criteria.andPhoneEqualTo(entity.getPhone());
           //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //记录者编号
        if (entity.getIdRecorder()!=null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        return outstorageMapper.selectByExample(outstorageExample);
    }
    public List<Outstorage> showQuantity(Aquaculture entity) throws Exception {
        float num=outStorageDao.checkQuantity(entity.getFeedType(),entity.getRemark());
        float count=entity.getFeedWeight();
        List<Outstorage> outstorageList=new ArrayList<Outstorage>(outStorageDao.manageOutstorage(entity.getFeedType(),entity.getRemark(),count));
        if(count>num) {
            Outstorage outstorage=new Outstorage();
            outstorage.setRest(num);
            ArrayList<Outstorage> outstorages = new ArrayList<Outstorage>();
            outstorages.add(outstorage);
            return outstorages;
        }
        else{
        //定义两个float变量sum，表示累加数;temp为定值float的0
        float sum=0;
        //开始进入循环体
        for (int i=0;i<outstorageList.size();i++){
            //将每个记录的剩余量取出来
            float a=outstorageList.get(i).getRest();
            //进行累加
            sum+=a;
            //如果累加的结果与所需要的量quantity相等
            if(sum==count) {
                //进行循环体
                for (int k=outstorageList.size()-1;k>i;k--) {
                    //将符合条件的记录取出来
                    outstorageList.remove(k);
                }
                break;
            }
            //如果累加的结果大于所需要的量quantity
            else if(sum>count) {
                for (int k=outstorageList.size()-1;k>i;k--){
                    //将符合记录但是没有剩余量的记录取出来
                    outstorageList.remove(k);
                }
                outstorageList.get(i).setRest(outstorageList.get(i).getRest()-sum+count);
                //结束上一层循环体，即跳出循环
                break;
            }
        }
        for (int h=0;h<outstorageList.size();h++){
            outstorageList.get(h).setType(null);
            outstorageList.get(h).setRemark(null);
            outstorageList.get(h).setName(null);
            outstorageList.get(h).setExpirationDate(null);
            outstorageList.get(h).setFirm(null);
            outstorageList.get(h).setQuantity(null);
            outstorageList.get(h).setIdCharge(null);
            outstorageList.get(h).setIdRecorder(null);
            outstorageList.get(h).setMode(null);
            outstorageList.get(h).setPhone(null);
            outstorageList.get(h).setRecordDate(null);
            outstorageList.get(h).setProvide(null);
            outstorageList.get(h).setSite(null);
            outstorageList.get(h).setUnit(null);
            outstorageList.get(h).setValid(null);
        }
        return outstorageList;
    }
    }

    public float checkQuantity(Aquaculture entity)throws Exception {
        String name=entity.getFeedType();
        String firm=entity.getRemark();
        if(outStorageDao.checkQuantity(name,firm)!=null&&!outStorageDao.checkQuantity(name,firm).equals("")){
            return outStorageDao.checkQuantity(name,firm);
        }
        else {
            return 0;
        }
    }
    public List<Outstorage> Listname(String type) throws Exception {
        //把listOutstorageByName返回的值放在ArrayList里面
        return outStorageDao.Listname(type);
    }
    //一个有效期的调度算法
    public void manageOutstorage(Aquaculture entity) throws Exception {
        //把manageOutstorage返回的值放在ArrayList里面
        float num=outStorageDao.checkQuantity(entity.getFeedType(),entity.getRemark());
        float count=entity.getFeedWeight();
        List<Outstorage> outstorageList=new ArrayList<Outstorage>(outStorageDao.manageOutstorage(entity.getFeedType(),entity.getRemark(),count));
        //定义两个float变量sum，表示累加数;temp为定值float的0
        float sum = 0;
        float temp = 0;
        //开始进入循环体
            for (int i = 0; i < outstorageList.size(); i++) {
                //将每个记录的剩余量取出来
                float a = outstorageList.get(i).getRest();
                //进行累加，将值给sum
                sum += a;
                //如果sum和所需要的量刚好相等
                if (sum == count) {
                    //进行循环体
                    for (int k = 0; k <=i; k++) {
                        //将符合的记录取出来，将他们的剩余量变为0
                        outstorageList.get(k).setRest(temp);
                        //将更改后的记录放到数据库
                        outstorageMapper.updateByPrimaryKeySelective(outstorageList.get(k));
                        //接下来创建一个实体，把他们写到养殖与物资的关系表中
                        AquaStor aquaStor=new AquaStor();
                        aquaStor.setAid(UUID.randomUUID().toString().replace("-","").toUpperCase());
                        aquaStor.setId(entity.getId());
                        aquaStor.setIdOutstorage(outstorageList.get(k).getIdOutstorage());
                        aquaStorService.add(aquaStor);
                    }
                    //break为跳出一重循环
                    break;
                    //结束上一层循环体，即跳出循环

                }
                //如果累加的结果大于所需要的量quantity
                else if (sum > count) {
                    //进行循环体
                    for (int k = 0; k < i; k++) {
                        //将符合记录但是没有剩余量的记录取出来，将这些记录的剩余量变为0
                        outstorageList.get(k).setRest(temp);
                        //将更改后的记录放到数据库
                        outstorageMapper.updateByPrimaryKeySelective(outstorageList.get(k));
                        AquaStor aquaStor=new AquaStor();
                        aquaStor.setAid(UUID.randomUUID().toString().replace("-","").toUpperCase());
                        aquaStor.setId(entity.getId());
                        aquaStor.setIdOutstorage(outstorageList.get(k).getIdOutstorage());
                        aquaStorService.add(aquaStor);
                    }
                    //将符合条件的但是仍有剩余量的记录取出来，并改变剩余量
                    outstorageList.get(i).setRest(sum - count);
                    //将更改后的记录放到数据库
                    outstorageMapper.updateByPrimaryKeySelective(outstorageList.get(i));
                    AquaStor aquaStor=new AquaStor();
                    aquaStor.setAid(UUID.randomUUID().toString().replace("-","").toUpperCase());
                    aquaStor.setId(entity.getId());
                    aquaStor.setIdOutstorage(outstorageList.get(i).getIdOutstorage());
                    aquaStorService.add(aquaStor);
                    //结束上一层循环体，即跳出循环
                    break;
                }


            }

        }
    }
