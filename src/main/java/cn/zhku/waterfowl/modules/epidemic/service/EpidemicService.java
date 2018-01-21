package cn.zhku.waterfowl.modules.epidemic.service;
import cn.zhku.waterfowl.modules.epiStor.service.EpiStorService;
import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.modules.outStorage.service.OutStorageService;
import cn.zhku.waterfowl.pojo.entity.*;
import cn.zhku.waterfowl.pojo.mapper.EpidemicMapper;
import cn.zhku.waterfowl.pojo.mapper.OutstorageMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EpidemicService  implements IBaseService<Epidemic>  {
    @Autowired
    private EpidemicMapper epidemicMapper;
    @Autowired
    private EpiStorService epiStorService;
    @Autowired
    private OutStorageDao outStorageDao;
    @Autowired
    private OutstorageMapper outstorageMapper;
    @Override
    /**
     * 根据epidemic实体插入
     */
    public int add(Epidemic entity) throws Exception {
        return epidemicMapper.insert(entity);
    }

    @Override
    /**
     * 根据epidemic实体更新
     * @param entity 映射数据库单表的实体类
     * @return 状态参数  1表示修改成功 0表示修改失败
     */
    public int update(Epidemic entity) throws Exception {

          return   epidemicMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    /**
     *根据epidemic实体类id删除
     * @param entity 映射数据库单表的实体类
     * @return 状态参数  1表示修改成功 0表示修改失败
     */
    public int delete(Epidemic entity) throws Exception {

            return epidemicMapper.deleteByPrimaryKey(entity.getId());

    }


    @Override
    /**
     * 根据id得到epdemic实体类
     */
    public Epidemic get(String idEpidemic) throws Exception {
        return epidemicMapper.selectByPrimaryKey(idEpidemic);
    }

    @Override
    /**
     * 根据epdemic实体类的id查询
     */
    public Epidemic get(Epidemic entity) throws Exception {
        EpidemicExample epidemicExample =new EpidemicExample();
        epidemicExample.or().andIdEqualTo(entity.getId());
        if (epidemicExample!=null) {
            return epidemicMapper.selectByExample(epidemicExample).get(0);
        }else {
            return null;
        }
    }
    @Override
    /**
     * 根据epidemic实体多条件查询
     */
    public List<Epidemic> findList(Epidemic entity) throws Exception {
        EpidemicExample epidemicExample =new EpidemicExample();
        EpidemicExample.Criteria criteria = epidemicExample.createCriteria();
        //禽舍编号
        if(StringUtils.isNoneBlank(entity.getIdPatch()))
            criteria.andIdPatchEqualTo(entity.getIdPatch());
        //  日期
        if (entity.getRecordDate()!=null)
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        //疾病
        if (StringUtils.isNoneBlank(entity.getDiseaes()))
            criteria.andDiseaesLike("%"+entity.getDiseaes()+"%");
        //给药方式
        if (StringUtils.isNoneBlank(entity.getProcessingMode()))
            criteria.andProcessingModeLike("%"+entity.getProcessingMode()+"%");
        //负责人编号
        if (StringUtils.isNoneBlank(entity.getIdCharge()))
            criteria.andIdChargeEqualTo(entity.getIdCharge());
       //批次编号
        if (StringUtils.isNoneBlank(entity.getIdPatch()))
            criteria.andIdPatchEqualTo(entity.getIdPatch());
        //记录者编号
        if (StringUtils.isNoneBlank(entity.getIdRecorder()))
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        //备注
        if (StringUtils.isNoneBlank(entity.getRemark()))
            criteria.andRemarkLike("%"+entity.getRemark()+"%");
        //处理方式
        if (StringUtils.isNoneBlank(entity.getProcessingMode()))
            criteria.andProcessingModeLike("%"+entity.getProcessingMode()+"%");
        //免疫，疾病标志
        if (StringUtils.isNoneBlank(entity.getSign()))
            criteria.andSignEqualTo(entity.getSign());
        //染病个体数
        if (entity.getNumInfected()!=null)
            criteria.andNumInfectedEqualTo(entity.getNumInfected());
        //id
        if(entity.getId()!=null)
            criteria.andIdEqualTo(entity.getId());
        //名称
        if (StringUtils.isNoneBlank(entity.getName()))
            criteria.andNameLike("%"+entity.getName()+"%");
        return epidemicMapper.selectByExample(epidemicExample);
    }

    //一个有效期的调度算法
    public void manageOutstorage(Epidemic entity) throws Exception {
        //把manageOutstorage返回的值放在ArrayList里面
        float num=outStorageDao.checkQuantity(entity.getName(),entity.getRemark());
        float count=entity.getDose();
        List<Outstorage> outstorageList=new ArrayList<Outstorage>(outStorageDao.manageOutstorage(entity.getName(),entity.getRemark(),count));
        //定义两个float变量sum，表示累加数;temp为定值float的0
        float sum = 0;
        float temp = 0;
        //开始进入循环体
        for (int i = 0; i < outstorageList.size(); i++) {
            //将每个记录的剩余量取出来
            float a = outstorageList.get(i).getRest();
            //进行累加
            sum += a;
            if (sum == count) {
                for (int k = 0; k <=i; k++) {
                    //将符合记录但是没有剩余量的记录取出来
                    outstorageList.get(k).setRest(temp);
                    //将这些记录的剩余量变为0
                    //将更改后的记录放到数据库
                    outstorageMapper.updateByPrimaryKeySelective(outstorageList.get(k));
                    EpiStor epiStor=new EpiStor();
                    epiStor.setEid(UUID.randomUUID().toString().replace("-","").toUpperCase());
                    epiStor.setId(entity.getId());
                    epiStor.setIdOutstorage(outstorageList.get(k).getIdOutstorage());
                    epiStorService.add(epiStor);
                }
                break;
                //结束上一层循环体，即跳出循环

            }
            //如果累加的结果大于所需要的量quantity
            else if (sum > count) {
                for (int k = 0; k < i; k++) {
                    //将符合记录但是没有剩余量的记录取出来
                    outstorageList.get(k).setRest(temp);
                    //将这些记录的剩余量变为0
                    //将更改后的记录放到数据库
                    outstorageMapper.updateByPrimaryKeySelective(outstorageList.get(k));
                    EpiStor epiStor=new EpiStor();
                    epiStor.setEid(UUID.randomUUID().toString().replace("-","").toUpperCase());
                    epiStor.setId(entity.getId());
                    epiStor.setIdOutstorage(outstorageList.get(k).getIdOutstorage());
                    epiStorService.add(epiStor);
                }
                //将符合条件的但是仍有剩余量的记录取出来
                //进行循环体
                outstorageList.get(i).setRest(sum - count);
                //改变该记录的剩余量
//                    less.setRest(sum - quantity);
                //将更改后的记录放到数据库
                outstorageMapper.updateByPrimaryKeySelective(outstorageList.get(i));
                EpiStor epiStor=new EpiStor();
                epiStor.setEid(UUID.randomUUID().toString().replace("-","").toUpperCase());
                epiStor.setId(entity.getId());
                epiStor.setIdOutstorage(outstorageList.get(i).getIdOutstorage());
                epiStorService.add(epiStor);
                //结束上一层循环体，即跳出循环
                break;
            }


        }

    }



}
