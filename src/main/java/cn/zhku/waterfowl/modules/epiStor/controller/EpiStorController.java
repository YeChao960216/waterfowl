package cn.zhku.waterfowl.modules.epiStor.controller;

import cn.zhku.waterfowl.modules.epiStor.service.EpiStorService;
import cn.zhku.waterfowl.pojo.entity.EpiStor;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
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
@RequestMapping("/epiStor/")
public class EpiStorController {
    @Autowired
    private EpiStorService epiStorService;

    /**
     *  在添加死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 添加Ddl表信息
     *  @param epiStor
     * @return Message
     */
    @ResponseBody
    @RequestMapping("save")
    public Message addEpiStor(EpiStor epiStor) throws Exception {
        epiStor.setEid(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if (epiStorService.add(epiStor)==1) {
            return new Message("1", "增加免疫用品记录成功");
        } else
            return new Message("2","增加免疫用品记录失败");
    }
    /**
     * 在删除死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 删除未提交Ddl表记录
     *  @param eid
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deteleEpiStor(@PathVariable String eid) throws Exception {
        EpiStor epiStor =new EpiStor();
        epiStor.setEid(eid);
        if (epiStorService.delete(epiStor) == 1) {
            return new Message("1", "删除免疫用品记录成功");
        } else
            return new Message("2","删除免疫用品记录失败");
    }
    /**
     * 在修改死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     * 修改Ddl表记录
     *  @param epiStor
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit")
    public Message editEpiStor(EpiStor epiStor) throws Exception {
        if (epiStorService.update(epiStor) == 1) {
            return new Message("1", "修改免疫用品记录成功");
        } else
            return new Message("2","修改免疫用品记录失败");
    }
    /**
     * 修改Ddl表记录
     *  @param eid
     *  @param epiStor
     * @return  Messages
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editEpiStor(@PathVariable String eid,EpiStor epiStor) throws Exception {
        epiStor.setEid(eid);
        if (epiStorService.update(epiStor) == 1) {
            return new Message("1", "修改免疫用品记录成功");
        } else
            return new Message("2","修改免疫用品记录失败");
    }

    /**
     * 根据Id查询Ddl表记录
     *  @param eid
     */
    @ResponseBody
    @RequestMapping("show/{eid}")
    public EpiStor showById(@PathVariable String eid) throws Exception {
        return epiStorService.get(eid);
    }
    /**
     * 多条件查询
     *  @param epiStor
     * @param  commonQo
     * @return  PageInfo<AquaStor>
     */
    @ResponseBody
    @RequestMapping("findList")
    public PageInfo<EpiStor> findListEpiStor(EpiStor epiStor, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize());
        //  通过服务层获取查询后的用户列表
        List<EpiStor> epiStorServiceList =  epiStorService.findList(epiStor);
        //  返回 pageBean实体
        return new PageInfo<EpiStor>(epiStorServiceList);
    }

}
