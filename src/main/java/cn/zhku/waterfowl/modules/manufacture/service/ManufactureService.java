package cn.zhku.waterfowl.modules.manufacture.service;

import cn.zhku.waterfowl.pojo.entity.AquacultureExample;
import cn.zhku.waterfowl.pojo.entity.Manufacture;
import cn.zhku.waterfowl.pojo.entity.ManufactureExample;
import cn.zhku.waterfowl.pojo.mapper.ManufactureMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 成君
 * @date  2018/1/24 2018/1/22 0022.
 * @E-mail 943193747@qq.com
 */
@Service
public class ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    /**
     * 增加记录
     * @param manufacture
     * @return
     */
    public int add(Manufacture manufacture) {
        return manufactureMapper.insert(manufacture);
    }

    /**
     * 根据主键删除记录
     * @param manufacture
     * @return 状态码 1 成功， 0 失败
     */
    public int delete(Manufacture manufacture) {
        return manufactureMapper.deleteByPrimaryKey(manufacture.getId());
    }

    /**
     * 修改
     * @param manufacture
     * @return
     */
    public int update(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKeySelective(manufacture);
    }

    /**
     * 根据主键返回 manufacture
     * @param id
     * @return
     */
    public Manufacture get(String id) {
        return manufactureMapper.selectByPrimaryKey(id);
    }

    /**
     * 处理多条件查询
     * @param manufacture
     * @return
     */
    public List<Manufacture> findList(Manufacture manufacture) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();

        if (StringUtils.isNotBlank(manufacture.getIdPatch()))   // 批次
            criteria.andIdPatchLike("%"+manufacture.getIdPatch()+"%");
        if (StringUtils.isNotBlank(manufacture.getFirm()))  // 加工厂商
            criteria.andFirmLike("%"+manufacture.getFirm()+"%");
        if (StringUtils.isNotBlank(manufacture.getSite())) // 加工地址
            criteria.andSiteLike("%"+manufacture.getSite()+"%");
        if (StringUtils.isNotBlank(manufacture.getMethod())) // 加工方法
            criteria.andMethodLike("%"+manufacture.getMethod()+"%");
        if (manufacture.getRecordDate()!=null)  // 加工日期
            criteria.andRecordDateEqualTo(manufacture.getRecordDate());
        if (StringUtils.isNotBlank(manufacture.getIdCharge() )) //  加工负责人
            criteria.andIdChargeEqualTo(manufacture.getIdCharge());
        return manufactureMapper.selectByExample(manufactureExample);
    }
}
