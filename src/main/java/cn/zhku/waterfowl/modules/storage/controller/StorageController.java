package cn.zhku.waterfowl.modules.storage.controller;
import cn.zhku.waterfowl.modules.storage.service.StorageService;
import cn.zhku.waterfowl.pojo.entity.Storage;
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
 * @author  : 叶超
 *  date    : 2017-11-9
 *  E-mail  : yc755909707@foxmail.com
 */
/**
 * 对存储outstorage状态操作的controller,继承BaseController以便使用全局变量和参数绑定
 */
@Controller
@RequestMapping("/storage/")
public class StorageController extends BaseController {
    @Autowired
    StorageService storageService;

    /** 增加存储记录
     * 测试完成
     * @param  storage 实体类的各种字段，如
     * @return storage
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addStorage(@PathVariable Storage storage) throws Exception {

        storage.setIdStorage(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
        if(storageService.add(storage) == 1)
            return new Message("1","添加库存记录成功");
        else
            return new Message("1","添加库存记录失败");
    }

    /** 根据记录表id删除对象
     * 测试完成
     * @param idStorage 只需id字段
     * @return message
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("delete/{idStorage}")
    public Message deleteStorage(@PathVariable String idStorage) throws Exception {
        Storage storage =  new Storage();
        storage.setIdStorage(idStorage);
        if(storageService.delete(storage) == 1)
            return new Message("1","删除库存记录成功");
        else
            return new Message("2","删除库存记录失败");
    }
    /** 根据id修改免疫记录
     *  测试成功
     * @param   id 不包括记录表的各个Storage实体类字段
     * @return  message
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editStorage(@PathVariable String id, Storage storage) throws Exception {
        storage.setIdStorage(id);
        if(storageService.update(storage) == 1)
            return new Message("1","修改库存记录成功");
        else
            return new Message("2","修改库存记录失败");
    }

    /** 根据id展示库存信息
     * 测试完成
     * @param idStorage   只需记录表id
     * @return Storage实体
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("list/{idStorage}")
    public Storage showById(@PathVariable String idStorage) throws Exception {
        return storageService.get(idStorage);
    }
    /**
     *  根据多个条件展示一列用户 => 多条件查询分页
     * @param storage   storage实体的各个字段
     * @param commonQo   通用查询类，拥有pageSize,
     * @return  PageInfo<Storage> 一个带有List<Storage>的pageBean
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("selectBy")
    public PageInfo<Storage> select(Storage storage, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize());
        //  通过服务层获取查询后的用户列表
        List<Storage> storageList =  storageService.findList(storage);
        //  返回 pageBean实体
        return new PageInfo<Storage>(storageList);
    }
    //分页展示库存记录
    /**
     *  根据多个条件展示一列用户 => 多条件查询分页
     * @param commonQo   通用查询类，拥有pageSize,
     * @return  PageInfo<Storage> 一个带有List<Storage>的pageBean
     * @throws Exception    sql
     */

    @ResponseBody
    @RequestMapping("show")
    public PageInfo<Storage> select(CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize());
        //  通过服务层获取查询后的用户列表
        List<Storage> storageList =  storageService.showAll();
        //  返回 pageBean实体
        return new PageInfo<Storage>(storageList);
    }

}

