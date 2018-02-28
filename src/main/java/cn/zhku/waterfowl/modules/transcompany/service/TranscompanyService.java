package cn.zhku.waterfowl.modules.transcompany.service;

import cn.zhku.waterfowl.pojo.entity.Transcompany;
import cn.zhku.waterfowl.pojo.entity.TranscompanyExample;
import cn.zhku.waterfowl.pojo.entity.Transportation;
import cn.zhku.waterfowl.pojo.entity.TransportationExample;
import cn.zhku.waterfowl.pojo.mapper.TranscompanyMapper;
import cn.zhku.waterfowl.pojo.mapper.TransportationMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 成君
 * @date  2018/1/24 2018/1/24 0022.
 * @E-mail 943193747@qq.com
 */
@Service
public class TranscompanyService {
    @Autowired
    TranscompanyMapper transcompanyMapper;

    /**
     * 增加记录
     * @param transcompany
     * @return
     */
    public int add(Transcompany transcompany) {
        return transcompanyMapper.insert(transcompany);
    }

    /**
     * 根据主键删除记录
     * @param transcompany
     * @return 状态码 1 成功， 0 失败
     */
    public int delete(Transcompany transcompany) {
        return transcompanyMapper.deleteByPrimaryKey(transcompany.getTid());
    }

    /**
     * 修改
     * @param transcompany
     * @return
     */
    public int update(Transcompany transcompany) {
        return transcompanyMapper.updateByPrimaryKeySelective(transcompany);
    }

    /**
     * 根据主键返回 transcompany
     * @param id
     * @return
     */
    public Transcompany get(String id) {
        return transcompanyMapper.selectByPrimaryKey(id);
    }

    /**
     * 处理多条件查询
     * @param transcompany
     * @return
     */
    public List<Transcompany> findList(Transcompany transcompany) {
        TranscompanyExample transcompanyExample = new TranscompanyExample();

        TranscompanyExample.Criteria criteria = transcompanyExample.createCriteria();

        if (StringUtils.isNotBlank(transcompany.getType()))   // 公司类型
            criteria.andTypeLike("%"+transcompany.getType()+"%");
        if (StringUtils.isNotBlank(transcompany.getName()))   // 运输公司名称
            criteria.andNameLike("%"+transcompany.getName()+"%");
        if (StringUtils.isNotBlank(transcompany.getAddress())) // 运输公司地址
            criteria.andAddressLike("%"+transcompany.getAddress()+"%");
        if (StringUtils.isNotBlank(transcompany.getPhone() )) //  公司电话
            criteria.andPhoneLike("%"+transcompany.getPhone()+"%");
        return transcompanyMapper.selectByExample(transcompanyExample);
    }

}
