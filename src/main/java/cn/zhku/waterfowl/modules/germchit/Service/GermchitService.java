package cn.zhku.waterfowl.modules.germchit.Service;

import cn.zhku.waterfowl.pojo.entity.Ddl;
import cn.zhku.waterfowl.pojo.entity.Germchit;
import cn.zhku.waterfowl.pojo.entity.GermchitExample;
import cn.zhku.waterfowl.pojo.mapper.GermchitMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GermchitService {
    @Autowired
    GermchitMapper germchitMapper;

    public int add(Germchit germchit) {
        return germchitMapper.insertSelective(germchit);
    }

    public int update(Germchit germchit) {
        return germchitMapper.updateByPrimaryKeySelective(germchit);
    }

    public Germchit get(String id) {
        return germchitMapper.selectByPrimaryKey(id);
    }

    public int delete(Germchit germchit) {
        return germchitMapper.deleteByPrimaryKey(germchit.getId());
    }

    public List<Germchit> findList(Germchit entity) {
        GermchitExample germchitExample = new GermchitExample();
        GermchitExample.Criteria criteria = germchitExample.createCriteria();
        //查询条件
        if (StringUtils.isNoneBlank(entity.getId()))
            criteria.andIdEqualTo(entity.getId());
        //负责人编号
        if (StringUtils.isNoneBlank(entity.getIdCharge()))
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //记录者编号
        if (StringUtils.isNoneBlank(entity.getIdRecord()))
            criteria.andIdRecordEqualTo(entity.getIdRecord());
        //孵化场编号
        if (StringUtils.isNoneBlank(entity.getIncubationPlant()))
            criteria.andChickDischargerEqualTo(entity.getIncubationPlant());
        //孵化器编号
        if (StringUtils.isNoneBlank(entity.getIncubator()))
            criteria.andIncubatorEqualTo(entity.getIncubator());
        //出雏器编号
        if (StringUtils.isNoneBlank(entity.getChickDischarger()))
            criteria.andChickDischargerEqualTo(entity.getChickDischarger());
        //种鸡溯源码
        if (StringUtils.isNoneBlank(entity.getIdBreeding()))
            criteria.andIdBreedingEqualTo(entity.getIdBreeding());
        //大于numtotal个体总数
        if (entity.getNumTotal()!=null&&entity.getNumTotal()>=0)
            criteria.andNumTotalBetween(0,entity.getNumTotal());

        return germchitMapper.selectByExample(germchitExample);
    }
}
