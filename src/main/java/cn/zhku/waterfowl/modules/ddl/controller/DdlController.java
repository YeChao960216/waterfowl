package cn.zhku.waterfowl.modules.ddl.controller;

import cn.zhku.waterfowl.modules.ddl.dao.DDLDao;
import cn.zhku.waterfowl.modules.ddl.model.DeathMethodVo;
import cn.zhku.waterfowl.modules.ddl.service.DdlService;
import cn.zhku.waterfowl.pojo.entity.Ddl;
import cn.zhku.waterfowl.util.SessionUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("ddl")
public class DdlController extends BaseController{

    @Autowired
    private DDLDao ddlDao;

    @Autowired
    DdlService ddlService;
    /**
     *  在添加死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 添加Ddl表信息
     *  @param ddl
     * @return Message
     */
    @ResponseBody
    @RequestMapping("save")
    public Message addDdl(Ddl ddl) throws Exception {
        //  从shrio Session中获取user的session,填充记录员的字段
        ddl.setIdRecorder(SessionUtil.getUserSession().getId());
        ddl.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        ddl.setRecordDate(new Date());
        if (ddlService.add(ddl)==1) {
            return new Message("1", "增加病死淘记录表成功");
        } else
            return new Message("2","增加病死淘记录表失败，已经提交的数据无法删除");
    }
    /**
     * 在删除死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 删除未提交Ddl表记录
     *  @param id
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deteleDdl(@PathVariable String id) throws Exception {
        Ddl ddl =new Ddl();
        ddl.setId(id);
        if (ddlService.delete(ddl) == 1) {
            return new Message("1", "删除病死淘记录表成功");
        } else
            return new Message("2","删除病死淘记录表失败，已经提交的数据无法删除");
    }
    /**
     * 在修改死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 修改Ddl表记录
     *  @param ddl
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit")
    public Message editDdl(Ddl ddl) throws Exception {
        if (ddlService.update(ddl) == 1) {
            return new Message("1", "修改病死淘记录表成功");
        } else
            return new Message("2","修改病死淘记录表失败,已经提交的数据无法删除");
    }
    /**
     * 修改Ddl表记录
     *  @param id
     *  @param ddl
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editDdl(@PathVariable  String id,Ddl ddl) throws Exception {
        ddl.setId(id);
        if (ddlService.update(ddl) == 1) {
            return new Message("1", "修改病死淘记录表成功");
        } else
            return new Message("2","修改病死淘记录表失败，已经提交的数据无法修改");
    }

    /**
     * 根据Id查询Ddl表记录
     *  @param id
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Ddl showById(@PathVariable String id) throws Exception {
        return ddlService.get(id);
    }
    /**
     * 多条件查询
     *  @param ddl
     * @param  commonQo
     * @return  PageInfo<Ddl>
     */
    @ResponseBody
    @RequestMapping("findList")
    public PageInfo<Ddl> findListDdl(Ddl ddl, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<Ddl> ddlList =  ddlService.findList(ddl);
        //  返回 pageBean实体
        return new PageInfo<Ddl>(ddlList);
    }

    /**
     * 查找各种死法的数目
     * @param idPatch   批次号
     * @return  死法和死法数量的集合
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("deathMethod")
    public List<DeathMethodVo> deathMethod(String idPatch) throws Exception {
        return ddlDao.findDeathMethod(idPatch);
    }

}
