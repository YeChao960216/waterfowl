package cn.zhku.waterfowl.modules.customer.service;

import cn.zhku.waterfowl.pojo.entity.*;
import cn.zhku.waterfowl.pojo.mapper.CustomerMapper;
import cn.zhku.waterfowl.pojo.mapper.TransportationMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 成君
 * @date  2018/1/24 2018/1/23 0022.
 * @E-mail 943193747@qq.com
 */
@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    /**
     * 增加记录
     * @param customer
     * @return
     */
    public int add(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     * 根据主键删除记录
     * @param customer
     * @return 状态码 1 成功， 0 失败
     */
    public int delete(Customer customer) {
        return customerMapper.deleteByPrimaryKey(customer.getCid());
    }

    /**
     * 修改
     * @param customer
     * @return
     */
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 根据主键返回 customer
     * @param cid
     * @return
     */
    public Customer get(String cid) {
        return customerMapper.selectByPrimaryKey(cid);
    }

    /**
     * 处理多条件查询
     * @param customer
     * @return
     */
    public List<Customer> findList(Customer customer) {
        CustomerExample customerExample = new CustomerExample();

        CustomerExample.Criteria criteria = customerExample.createCriteria();

        if (StringUtils.isNotBlank(customer.getName()))  // 顾客姓名
            criteria.andNameEqualTo(customer.getName());
        if (StringUtils.isNotBlank(customer.getPhone() )) //  顾客电话
            criteria.andPhoneLike("%"+customer.getPhone()+"%");
        return customerMapper.selectByExample(customerExample);
    }

}
