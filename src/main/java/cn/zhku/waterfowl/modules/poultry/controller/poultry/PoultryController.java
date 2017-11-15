package cn.zhku.waterfowl.modules.poultry.controller.poultry;

import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseController;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageInfo;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/14 18:21.
 * 说明：
 */
public class PoultryController  implements IBaseController<Poultry>{

    /**
     * 增加一条数据
     *
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @Override
    public Message add(Poultry entity) throws Exception {
        return null;
    }

    /**
     * 删除一条记录
     *
     * @param  entity id 表主键
     * @return Message
     * 1     * @throws Exception   sql、bean检验
     */
    @Override
    public Message delete(Poultry entity) throws Exception {
        return null;
    }

    /**
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @Override
    public Message update(Poultry entity) throws Exception {
        return null;
    }

    /**
     * 获取一条记录
     *
     * @param id 表主键
     * @return Message
     * @throws Exception sql、bean检验
     */
    @Override
    public Poultry get(String id) throws Exception {
        return null;
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
    public PageInfo<Poultry> list(Poultry entity, CommonQo commonQo) throws Exception {
        return null;
    }
}
