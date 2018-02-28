package cn.zhku.waterfowl.modules.germchit.Controller;
import cn.zhku.waterfowl.modules.germchit.Service.GermchitService;
import cn.zhku.waterfowl.pojo.entity.Germchit;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.UUID;
import cn.zhku.waterfowl.util.SessionUtil;
@Controller
@RequestMapping("germchit")
public class GermchitController extends BaseController {

    @Autowired
    GermchitService germchitService;

    /**
     *  在添加死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 添加Ddl表信息
     *  @param germchit
     * @return Message
     */
    @ResponseBody
    @RequestMapping("save")
    public Message addGermchit(Germchit germchit) throws Exception {
        //  从shrio Session中获取user的session,填充记录员的字段66666666666666
//            germchit.setIdRecord(SessionUtil.getUserSession().getId());
        //溯源码拼接规则为: 上阶段溯源码 +  本阶段标识符“D” +该阶段溯源码
        //若上阶段溯源码不存在则跳过
        if (StringUtils.isNoneBlank(germchit.getIdBreeding())){
            germchit.setId(germchit.getIdBreeding()+"D"+UUID.randomUUID().toString().replace("-","").toLowerCase());
        }else {
            germchit.setId("D" + UUID.randomUUID().toString().replace("-", "").toLowerCase());
        }
        if (germchitService.add(germchit)==1) {
            return new Message("1", "增加种苗记录表成功",germchit.getId());
        } else
            return new Message("2","增加种苗记录表失败");
    }
    /**
     * 在删除死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 删除未提交Ddl表记录
     *  @param id
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deteleGermchit(@PathVariable String id) throws Exception {
        Germchit germchit =new Germchit();
        germchit.setId(id);
        if (germchitService.delete(germchit) == 1) {
            return new Message("1", "删除种苗记录表成功");
        } else
            return new Message("2","删除种苗记录表失败");
    }
    /**
     * 在修改死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 修改Ddl表记录
     *  @param germchit
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit")
    public Message editGermchit(Germchit germchit) throws Exception {
        if (germchitService.update(germchit) == 1) {
            return new Message("1", "修改种苗记录表成功");
        } else
            return new Message("2","修改种苗记录表失败");
    }

    /**
     * 根据Id查询Germchit表记录
     *  @param id
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Germchit showById(@PathVariable String id) throws Exception {
        return germchitService.get(id);
    }
    /**
     * 多条件查询
     *  @param germchit
     * @param  commonQo
     * @return  PageInfo<Ddl>
     */
    @ResponseBody
    @RequestMapping("findList")
    public PageInfo<Germchit> findListGermchit(Germchit germchit, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<Germchit> germchitList =  germchitService.findList(germchit);
        //  返回 pageBean实体
        return new PageInfo<Germchit>(germchitList);
    }

}

