package cn.zhku.waterfowl.modules.outStorage.controller;

/**
 * @author  : 叶超
 *  date    : 2017-11-9
 *  E-mail  : yc755909707@foxmail.com
 */

import cn.zhku.waterfowl.modules.outStorage.service.OutStorageService;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
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
 * 对出库outstorage状态操作的controller,继承BaseController以便使用全局变量和参数绑定
 */
@Controller
@RequestMapping("/outstorage/")
public class OutStorageController extends BaseController{
        @Autowired
        OutStorageService outStorageService;

        /** 增加出库记录
         * 测试完成
         * @param  outstorage 实体类的各种字段，如
         * @return storage
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("add")
        public Message addStorage(@PathVariable Outstorage outstorage) throws Exception {

            outstorage.setIdStorage(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
            if(outStorageService.add(outstorage) == 1)
                return new Message("1","添加出库记录成功");
            else
                return new Message("1","添加出库记录失败");
        }

        /** 根据记录表id删除对象
         * 测试完成
         * @param idOutStorage 只需id字段
         * @return message
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("delete/{idOutStorage}")
        public Message deleteStorage(@PathVariable String idOutStorage) throws Exception {
            Outstorage outstorage =  new Outstorage();
            outstorage.setIdStorage(idOutStorage);
            if(outStorageService.delete(outstorage) == 1)
                return new Message("1","删除出库记录成功");
            else
                return new Message("2","删除出库记录失败");
        }
        /** 根据id修改出库记录
         *  测试成功
         * @param   id,Storage 不包括记录表的各个Outstorage实体类字段
         * @return  message
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("edit/{id}")
        public Message editStorage(@PathVariable String id, Outstorage outstorage) throws Exception {
            outstorage.setIdOutstorage(id);
            if(outStorageService.update(outstorage) == 1)
                return new Message("1","修改出库记录成功");
            else
                return new Message("2","修改出库记录失败");
        }

        /** 根据id展示出库信息
         * 测试完成
         * @param idOutStorage   只需记录表id
         * @return OutStorage实体
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("show/{idOutStorage}")
        public Outstorage showById(@PathVariable String idOutStorage) throws Exception {
            return outStorageService.get(idOutStorage);
        }
        /**
         *  根据多个条件展示一列用户 => 多条件查询分页
         * @param outstorage outstorage实体的各个字段
         * @param commonQo   通用查询类，拥有pageSize,
         * @return  PageInfo<OutStorage> 一个带有List<OutStorage>的pageBean
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("selectBy")
        public PageInfo<Outstorage> select(Outstorage outstorage, CommonQo commonQo) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize());
            //  通过服务层获取查询后的用户列表
            List<Outstorage> outstorageList =  outStorageService.findList(outstorage);
            //  返回 pageBean实体
            return new PageInfo<Outstorage>(outstorageList);
        }
        //分页展示出库记录
        /**
         *  根据多个条件展示一列用户 => 多条件查询分页
         * @param commonQo   通用查询类，拥有pageSize,
         * @return  PageInfo<Outstorage> 一个带有List<Outstorage>的pageBean
         * @throws Exception    sql
         */

        @ResponseBody
        @RequestMapping("show")
        public PageInfo<Outstorage> select(CommonQo commonQo) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize());
            //  通过服务层获取查询后的用户列表
            List<Outstorage> outstorageList =  outStorageService.showAll();
            //  返回 pageBean实体
            return new PageInfo<Outstorage>(outstorageList);
        }

    }

