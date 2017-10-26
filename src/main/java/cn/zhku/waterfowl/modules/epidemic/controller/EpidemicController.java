package cn.zhku.waterfowl.modules.epidemic.controller;

import cn.zhku.waterfowl.modules.epidemic.service.EpidemicService;

import cn.zhku.waterfowl.pojo.entity.Epidemic;

import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.UUID;

/**
 * @author  : 林伟佳 gonefutre
 *  date    : 2017-10-26
 *  E-mail  : 984613906@qq.com
 */
    /**
     * 对免疫epidemic状态操作的controller,继承BaseController以便使用全局变量和参数绑定
     */
    @Controller
    @RequestMapping("{epidemicPath}")
    public class EpidemicController extends BaseController {
        @Autowired
        EpidemicService epidemicService;
        @Autowired
        //增加用户
        /** 增加免疫记录
         *
         * @param  epidemic 实体类的各种字段，如
         * @return epidemic
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("epidemic")
        public int addEpidemic(Epidemic epidemic) throws Exception {
            epidemic.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
            return epidemicService.add(epidemic);
        }
        /** 根据记录表id删除对象
         *
         * @param id   只需id字段
         * @return 状态码  0 为失败， 1为成功
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("delete/{id}")
        public int deleteEpidemic(@PathVariable String id) throws Exception {
            Epidemic epidemic = new Epidemic();
            epidemic.setId(id);
            return epidemicService.delete(epidemic);
        }
        /** 根据id修改免疫记录
         *
         * @param   id 包括记录表id的各个Epidemic实体类字段
         * @return  状态码  0 为失败， 1为成功
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("edit/{id}")
        public int editEpidemic(@PathVariable String id,Epidemic epidemic) throws Exception {
            epidemic.setId(id);
            return epidemicService.update(epidemic);
        }

        /** 根据id展示免疫信息
         * @param id   只需记录表id
         * @return Epidemic实体
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("show/{id}")
        public Epidemic showEpidemic(@PathVariable String id) throws Exception {
            return epidemicService.get(id);
        }
        //分页展示免疫记录表
        /**
         *  根据多个条件展示一列用户 => 多条件查询分页
         * @param epidemic   epidemic实体的各个字段
         * @param commonQo   通用查询类，拥有pageSize,
         * @return  PageInfo<Epidemic> 一个带有List<User>的pageBean
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("showFindList")
        public PageInfo<Epidemic> listEpidemic(Epidemic epidemic, CommonQo commonQo) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
            //  通过服务层获取查询后的用户列表
            List<Epidemic> epidemicList =  epidemicService.findList(epidemic);
            //  返回 pageBean
            return new PageInfo<Epidemic>(epidemicList);
        }

    }

