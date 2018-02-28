package cn.zhku.waterfowl.modules.aquaStor.controller;

import cn.zhku.waterfowl.modules.aquaStor.service.AquaStorService;
import cn.zhku.waterfowl.pojo.entity.AquaStor;
import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.util.SessionUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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

        aquaStor.setAid(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if (aquaStorService.add(aquaStor)==1) {
            return new Message("1", "增加饲料记录成功");
        } else
            return new Message("2","增加饲料记录失败");
    }
    /**
     * 在删除死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 删除未提交Ddl表记录
     *  @param aid
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deteleAquaStor(@PathVariable String aid) throws Exception {
        AquaStor aquaStor =new AquaStor();
        aquaStor.setAid(aid);
        if (aquaStorService.delete(aquaStor) == 1) {
            return new Message("1", "删除饲料记录成功");
        } else
            return new Message("2","删除饲料记录失败");
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
            return new Message("1", "修改饲料记录成功");
        } else
            return new Message("2","修改饲料记录失败");
    }
    /**
     * 修改Ddl表记录
     *  @param eid
     *  @param aquaStor
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editAquaStor(@PathVariable  String eid,AquaStor aquaStor) throws Exception {
        aquaStor.setAid(eid);
        if (aquaStorService.update(aquaStor) == 1) {
            return new Message("1", "修改饲料记录成功");
        } else
            return new Message("2","修改饲料记录失败");
    }

    /**
     * 根据Id查询Ddl表记录
     *  @param aid
     */
    @ResponseBody
    @RequestMapping("show/{eid}")
    public AquaStor showById(@PathVariable String aid) throws Exception {
        return aquaStorService.get(aid);
    }
    /**
     * 多条件查询
     *  @param aquaStor
     * @param  commonQo
     * @return  PageInfo<AquaStor>
     */
    @ResponseBody
    @RequestMapping("findList")
    public PageInfo<AquaStor> findListAquaStor(AquaStor aquaStor, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize());
        //  通过服务层获取查询后的用户列表
        List<AquaStor> aquaStorList =  aquaStorService.findList(aquaStor);
        //  返回 pageBean实体
        return new PageInfo<AquaStor>(aquaStorList);
    }


}
