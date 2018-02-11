package cn.zhku.waterfowl.modules.customer.controller;


import cn.zhku.waterfowl.modules.customer.service.CustomerService;
import cn.zhku.waterfowl.pojo.entity.Customer;
import cn.zhku.waterfowl.pojo.entity.Transcompany;
import cn.zhku.waterfowl.pojo.entity.Transportation;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author 成君
 * @date 21:28 2018/1/24
 * @E-mail 943193747@qq.com
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * 增加记录
     * @param customer
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addCustomer(Customer customer) throws Exception {
        customer.setCid(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位大小的UUID来设置记录id
        if (customerService.add(customer) == 1) {
            return new Message("1", "成功增加1条记录");
        } else {
            return new Message("2", "增加记录失败");
        }
    }

    /**
     * 删除记录
     * @param id
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deleteCustomer(@PathVariable String id) throws Exception {
        Customer customer = new Customer();
        customer.setCid(id);
        if (customerService.delete(customer) == 1)
            return new Message("1", "成功删除1条记录");
        else
            return new Message("2", "删除记录失败");
    }

    /**
     * 修改记录
     * @param id
     * @param customer
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editCustomer (@PathVariable String id, Customer customer) throws Exception {
        customer.setCid(id);
        if (customerService.update(customer) == 1)
            return new Message("1", "修改记录成功");
        else
            return new Message("2", "修改记录失败");

    }

    /**
     * 展示一条记录
     * @param id
     * @return customer
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Customer showCustomer(@PathVariable String id) throws Exception {
        return customerService.get(id);
    }


    /**
     * 分页展示客户信息表的所有记录
     *
     * @param customer
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("listCustomer")
    public PageInfo<Customer> listCustomer(Customer customer, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "cid desc");
        //  通过服务层获取查询后的用户列表
        List<Customer> customerServiceList = customerService.findList(customer);
        //  返回 pageBean
        return new PageInfo<Customer>(customerServiceList);

    }
}
