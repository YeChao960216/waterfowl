package cn.zhku.waterfowl.modules.aquaStor.controller;

import cn.zhku.waterfowl.modules.aquaStor.service.AquaStorService;
import cn.zhku.waterfowl.pojo.entity.AquaStor;
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
 * Created by Administrator on 2018/1/17 0017.
 */
@Controller
@RequestMapping("/aquaStor/")
public class AquaStorController extends BaseController{
    @Autowired
    private AquaStorService aquaStorService;

    /**
     *  在添加死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 添加Ddl表信息
     *  @param aquaStor
     * @return Message
     */
    @ResponseBody
    @RequestMapping("save")
    public Message addAquaStor(AquaStor aquaStor) throws Exception {
        aquaStor.setKey(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if (aquaStorService.add(aquaStor)==1) {
            return new Message("1", "增加病死淘记录表成功");
        } else
            return new Message("2","增加病死淘记录表失败，已经提交的数据无法删除");
    }
    /**
     * 在删除死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 删除未提交Ddl表记录
     *  @param key
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deteleAquaStor(@PathVariable String key) throws Exception {
        AquaStor aquaStor =new AquaStor();
        aquaStor.setKey(key);
        if (aquaStorService.delete(aquaStor) == 1) {
            return new Message("1", "删除病死淘记录表成功");
        } else
            return new Message("2","删除病死淘记录表失败，已经提交的数据无法删除");
    }
    /**
     * 在修改死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 修改Ddl表记录
     *  @param aquaStor
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit")
    public Message editAquaStor(AquaStor aquaStor) throws Exception {
        if (aquaStorService.update(aquaStor) == 1) {
            return new Message("1", "修改病死淘记录表成功");
        } else
            return new Message("2","修改病死淘记录表失败,已经提交的数据无法删除");
    }
    /**
     * 修改Ddl表记录
     *  @param key
     *  @param aquaStor
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editAquaStor(@PathVariable  String key,AquaStor aquaStor) throws Exception {
        aquaStor.setKey(key);
        if (aquaStorService.update(aquaStor) == 1) {
            return new Message("1", "修改病死淘记录表成功");
        } else
            return new Message("2","修改病死淘记录表失败，已经提交的数据无法修改");
    }

    /**
     * 根据Id查询Ddl表记录
     *  @param key
     */
    @ResponseBody
    @RequestMapping("show/{key}")
    public AquaStor showById(@PathVariable String key) throws Exception {
        return aquaStorService.get(key);
    }
    /**
     * 多条件查询
     *  @param aquaStor
     * @param  commonQo
     * @return  PageInfo<AquaStor>
     */
    @ResponseBody
    @RequestMapping("findList")
    public PageInfo<AquaStor> findListDdl(AquaStor aquaStor, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<AquaStor> aquaStorList =  aquaStorService.findList(aquaStor);
        //  返回 pageBean实体
        return new PageInfo<AquaStor>(aquaStorList);
    }


}