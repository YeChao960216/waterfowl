package cn.zhku.waterfowl.modules.material.controller;

import cn.zhku.waterfowl.modules.material.service.MaterialService;
import cn.zhku.waterfowl.pojo.entity.Material;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseController;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/14 18:23.
 * 说明：
 */
@RestController
public class MaterialController implements IBaseController<Material> {
    @Autowired
    MaterialService materialService;




    /**
     * 增加一条数据
     *
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @Override
    public Message add(Material entity) throws Exception {
        if (materialService.add(entity) == 1)
            return new Message("1","插入材料成功");
        else
            return new Message("2","插入材料失败");

    }

    /**
     * 删除一条记录
     *
     * @param entity id 表主键
     * @return Message
     * 1     * @throws Exception   sql、bean检验
     */
    @Override
    public Message delete(Material entity) throws Exception {
        if (materialService.delete(entity) == 1)
            return new Message("1","成功删除材料");
        else
            return new Message("2","删除材料失败");
    }

    /**
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @Override
    public Message update(Material entity) throws Exception {
        if (materialService.update(entity) == 1)
            return new Message("1","更新材料信息成功");
        else
            return new Message("2","更新材料信息失败");
    }

    /**
     * 获取一条记录
     *
     * @param id 表主键
     * @return Message
     * @throws Exception sql、bean检验
     */
    @Override
    public Material get(String id) throws Exception {
        return materialService.get(id);
    }

    /**
     * 获取一个分页的数据列表
     *
     * @param entity   实体类
     * @param commonQo 通用查询类
     * @return PageInfo分页类
     * @throws Exception sql、bean检验
     */
    @Override
    public PageInfo<Material> list(Material entity, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),"date desc");

        return new PageInfo<>(materialService.findList(entity));
    }
}
