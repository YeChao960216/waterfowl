package cn.zhku.waterfowl.modules.epidemic.service;
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
     */
    public int update(Epidemic entity) throws Exception {
        return epidemicMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    /**
     *根据epidemic实体类id删除
     */
    public int delete(Epidemic entity) throws Exception {
        return epidemicMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    /**
     * 根据id得到epdemic实体类
     */
    public Epidemic get(String id) throws Exception {
        return epidemicMapper.selectByPrimaryKey(id);
    }

    @Override
    /**
     * 根据epdemic实体类的id查询
     */
    public Epidemic get(Epidemic entity) throws Exception {
        EpidemicExample epidemicExample =new EpidemicExample();
        epidemicExample.or().andIdBatchEqualTo(entity.getId());
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
        //  日期
        if (entity.getDate()!=null)
            criteria.andDateEqualTo(entity.getDate());
        //疾病
        if (entity.getDiseaes()!=null)
            criteria.andDiseaesLike("%"+entity.getDiseaes()+"%");
        //给药方式
        if (entity.getProcessingMode()!=null)
            criteria.andProcessingModeLike("%"+entity.getProcessingMode()+"%");
        //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //批次编号
        if (entity.getIdBatch()!=null)
            criteria.andIdBatchEqualTo(entity.getIdBatch());
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
        // 库存编号                                   这个字段有毒!!!
        if (entity.getInventoryId()!=null)
            criteria.andInventoryIdEqualTo(entity.getInventoryId());
        return epidemicMapper.selectByExample(epidemicExample);
    }

    public List<Epidemic> showAllByFlag(int flag) {
        EpidemicExample epidemicExample =new EpidemicExample();
        EpidemicExample.Criteria criteria = epidemicExample.createCriteria();
        criteria.andFlagEqualTo(flag);
        return epidemicMapper.selectByExample(epidemicExample);
    }
}
