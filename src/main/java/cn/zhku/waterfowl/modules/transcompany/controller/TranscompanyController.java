package cn.zhku.waterfowl.modules.transcompany.controller;


import cn.zhku.waterfowl.modules.transcompany.service.TranscompanyService;
import cn.zhku.waterfowl.pojo.entity.Transcompany;
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
 * @date  2018/1/24 2018/1/24 0022.
 * @E-mail 943193747@qq.com
 */
@Controller
@RequestMapping("/transcompany")
public class TranscompanyController {

    @Autowired
    TranscompanyService transcompanyService;

    /**
     * 增加记录
     * @param transcompany
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addTranscompany(Transcompany transcompany) throws Exception {
        transcompany.setTid(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位大小的UUID来设置记录id
        if (transcompanyService.add(transcompany) == 1) {
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
    public Message deleteTranscompany(@PathVariable String id) throws Exception {
        Transcompany transcompany = new Transcompany();
        transcompany.setTid(id);
        if (transcompanyService.delete(transcompany) == 1)
            return new Message("1", "成功删除1条记录");
        else
            return new Message("2", "删除记录失败");
    }

    /**
     * 修改记录
     * @param id
     * @param transcompany
     * * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editTranscompany (@PathVariable String id, Transcompany transcompany) throws Exception {
        transcompany.setTid(id);
        if (transcompanyService.update(transcompany) == 1)
            return new Message("1", "修改记录成功");
        else
            return new Message("2", "修改记录失败");

    }

    /**
     * 展示一条记录
     * @param id
     * @return transcompany     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Transcompany showTranscompany(@PathVariable String id) throws Exception {
        return transcompanyService.get(id);
    }


    /**
     * 分页展示运输公司信息表的所有记录
     *
     * @param transcompany
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("listtranscompany")
    public PageInfo<Transcompany> listTranscompany(Transcompany transcompany, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "tid desc");
        //  通过服务层获取查询后的用户列表
        List<Transcompany> transcompanyList = transcompanyService.findList(transcompany);
        //  返回 pageBean
        return new PageInfo<Transcompany>(transcompanyList);
    }

}
