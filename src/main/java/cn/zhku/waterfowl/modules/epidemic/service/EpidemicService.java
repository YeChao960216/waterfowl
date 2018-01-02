package cn.zhku.waterfowl.modules.epidemic.service;
import cn.zhku.waterfowl.modules.epidemic.dao.EpidemicDao;
import cn.zhku.waterfowl.pojo.entity.Epidemic;
import cn.zhku.waterfowl.pojo.entity.EpidemicExample;
import cn.zhku.waterfowl.pojo.mapper.EpidemicMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EpidemicService  implements IBaseService<Epidemic>  {
    @Autowired
    private EpidemicMapper epidemicMapper;
    @Autowired
    private EpidemicDao epidemicDao;
    @Override
    /**
     * 根据epidemic实体插入
     */
    public int add(Epidemic entity) throws Exception {
        return epidemicMapper.insert(entity);
    }
    /**
    *根据id修改提交状态为已经提交
    *
     * @param idList*/
    public  int updateFlag(String[] idList){

            try {
                for (String id:idList) {
                    epidemicDao.updateFlagById(id);
                }
                return 1;
            }catch (Exception e){
                return 0;
            }
    }
    public int updateFlag(String id){
        try {
            epidemicDao.updateFlagById(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    /**
     * 根据epidemic实体更新
     * @param entity 映射数据库单表的实体类
     * @return 状态参数  1表示修改成功 0表示修改失败
     */
    public int update(Epidemic entity) throws Exception {
        if (checkFlag(entity)==0) {
            epidemicMapper.updateByPrimaryKeySelective(entity);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    /**
     *根据epidemic实体类id删除
     * @param entity 映射数据库单表的实体类
     * @return 状态参数  1表示修改成功 0表示修改失败
     */
    public int delete(Epidemic entity) throws Exception {
        if (checkFlag(entity)==0) {
            epidemicMapper.deleteByPrimaryKey(entity.getId());
            return 1;
        }else {
            return 0;
        }
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
        //是否提交
        if(entity.getFlag()!=null)
            criteria.andFlagEqualTo(entity.getFlag());
        //禽舍编号
        if(entity.getIdPatch()!=null)
            criteria.andIdPatchEqualTo(entity.getIdPatch());
        //  日期
        if (entity.getRecordDate()!=null)
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        //疾病
        if (entity.getDiseaes()!=null)
            criteria.andDiseaesLike("%"+entity.getDiseaes()+"%");
        //给药方式
        if (entity.getProcessingMode()!=null)
            criteria.andProcessingModeLike("%"+entity.getProcessingMode()+"%");
        //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
//        //批次编号
//        if (entity.getIdBatch()!=null)
//            criteria.andIdBatchEqualTo(entity.getIdBatch());
        //记录者编号
        if (entity.getIdRecorder()!=null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        //备注
        if (entity.getRemark()!=null)
            criteria.andRemarkLike("%"+entity.getRemark()+"%");
        //处理方式
        if (entity.getProcessingMode()!=null)
            criteria.andProcessingModeLike("%"+entity.getProcessingMode()+"%");
        //免疫，疾病标志
        if (entity.getSign()!=null)
            criteria.andSignEqualTo(entity.getSign());
        //染病个体数
        if (entity.getNumInfected()!=null)
            criteria.andNumInfectedEqualTo(entity.getNumInfected());
        if (entity.getName()!=null)
            criteria.andNameLike("%"+entity.getName()+"%");
        return epidemicMapper.selectByExample(epidemicExample);
    }

    public List<Epidemic> showAllByFlag(int flag) {
        EpidemicExample epidemicExample =new EpidemicExample();
        EpidemicExample.Criteria criteria = epidemicExample.createCriteria();
        criteria.andFlagEqualTo(flag);
        return epidemicMapper.selectByExample(epidemicExample);
    }
    /*
   *检查提交状态
   * 其中1为已经提交, 0为未提交
   * */
    private int checkFlag(Epidemic entity) throws Exception {
        Epidemic epidemic = get(entity);
        if (epidemic.getFlag()==1){
            return 1;
        }else return 0;
    }


}
