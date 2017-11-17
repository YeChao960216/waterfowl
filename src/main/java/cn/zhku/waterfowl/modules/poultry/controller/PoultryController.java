package cn.zhku.waterfowl.modules.poultry.controller;

import cn.zhku.waterfowl.modules.poultry.service.PoultryService;
import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseController;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/14 18:21.
 * 说明：水禽表的接口
 * */
@RestController
@RequestMapping("/poultry")
public class PoultryController  implements IBaseController<Poultry>{

    @Autowired
    private PoultryService poultryService;

    /**
     * 增加一条数据
     *
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @RequestMapping("/new")
    @Override
    public Message add(Poultry entity) throws Exception {
        entity.setIdPoultry(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位长度的UUID来设置用户id
        if (poultryService.add(entity) == 1)
            return new Message("1","增加家禽成功");
        else
            return new Message("2","增加家禽失败");

    }

    /**
     * 删除一条记录
     *
     * @param  entity id 表主键
     * @return Message
     * 1     * @throws Exception   sql、bean检验
     */

    @RequestMapping("/delete/{id}")
    @Override
    public Message delete(@PathVariable String id, Poultry entity) throws Exception {
        entity.setIdPoultry(id);
        if (poultryService.delete(entity) == 1)
            return new Message("1","删除家禽成功");
        else
            return new Message("2","删除家禽失败");
    }

    /**
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @RequestMapping("/edit/{id}")
    @Override
    public Message update(@PathVariable String id, Poultry entity) throws Exception {
        if (poultryService.update(entity) == 1)
            return new Message("1","更新家禽成功");
        else
            return new Message("2","更新家禽失败");
    }

    /**
     * 获取一条记录
     *
     * @param id 表主键
     * @return Message
     * @throws Exception sql、bean检验
     */
    @RequestMapping("/show/{id}")
    @Override
    public Poultry get(@PathVariable String id) throws Exception {
        return poultryService.get(id);
    }

    /**
     * 获取一个分页的数据列表
     *
     * @param entity   实体类
     * @param commonQo 通用查询类
     * @return PageInfo分页类
     * @throws Exception sql、bean检验
     */
    @RequestMapping("/list")
    @Override
    public PageInfo<Poultry> list(Poultry entity, CommonQo commonQo) throws Exception {
        //  设置默认的排序，如果前端需要排训查询，则加上参数  sort = 数据库字段 ，
        if (commonQo.getSort().equals("1"))  //字符串"1"是sort的默认值，相当于 order by 1 ,即按主键排序
            commonQo.setSort("date desc");
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),"date desc");
        return new PageInfo<>(poultryService.list(entity,commonQo));
    }
}
