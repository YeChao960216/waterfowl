package cn.zhku.waterfowl.modules.epidemic.service;
import cn.zhku.waterfowl.pojo.entity.Epidemic;
import cn.zhku.waterfowl.pojo.entity.EpidemicExample;
import cn.zhku.waterfowl.pojo.mapper.EpidemicMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EpidemicService  implements IBaseService<Epidemic>  {
    @Autowired
    private EpidemicMapper epidemicMapper;
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
//        //批次编号
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



}
