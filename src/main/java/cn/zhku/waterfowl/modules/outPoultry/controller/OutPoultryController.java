package cn.zhku.waterfowl.modules.outPoultry.controller;

import cn.zhku.waterfowl.modules.outPoultry.servie.OutPoultryService;
import cn.zhku.waterfowl.modules.patch.service.PatchService;
import cn.zhku.waterfowl.pojo.entity.OutPoultry;
import cn.zhku.waterfowl.pojo.entity.Patch;
import cn.zhku.waterfowl.util.SessionUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.util.modle.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/outpoultry")
public class OutPoultryController {
    @Autowired
    OutPoultryService outPoultryService;
    @Autowired
    PatchService patchService;

    /**
     * 增加一条记录
     * @param outPoultry
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/add")
    public Msg addOutPoultry(OutPoultry outPoultry) throws Exception{
        //  从shrio Session中获取user的session,填充记录员的字段
        outPoultry.setIdRecord(SessionUtil.getUserSession().getId());
        String uuid =UUID.randomUUID().toString().replace("-","").toUpperCase();
        outPoultry.setId(uuid);   //用32位大小的UUID来设置记录id
        //   本次出库相关的批次记录
        Patch patch = patchService.get(outPoultry.getIdPatch());
        //  更新批次表的准备工作
        Patch upDatePatch = new Patch();
        upDatePatch.setId(outPoultry.getIdPatch());
        if(patch.getSize() - outPoultry.getQuantity() == 0){ //如果一次过全部都出厂了就修改原批次状态为30013 已全部出厂状态
            upDatePatch.setStatus("30013");
        }
        upDatePatch.setSize(patch.getSize() - outPoultry.getQuantity());

        // gonefuture修改于2018/2/3， 应该比较的是属性size而不是numtotal
        if(outPoultry.getQuantity()>patch.getNumTotal()){
            return new Msg("3","增加记录失败，该批次数量不足");
        }
        else if(outPoultryService.add(outPoultry)==1 && patchService.update(upDatePatch) == 1){
            return new Msg("1","成功增加1条记录","200",uuid);
        }
        else{
            return new Msg("2","增加记录失败");}
    }

    /**
     * 删除记录
     * @param id
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deleteOutPoultry(@PathVariable String id) throws Exception {
        OutPoultry outPoultry = new OutPoultry();
        outPoultry.setId(id);
        if (outPoultryService.delete(outPoultry)==1)
            return new Message("1","成功删除1条记录");
        else
            return new Message("2","删除记录失败");
    }

    /**
     * 修改记录
     * @param id
     * @param outPoultry
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editOutPoultry(@PathVariable String id,OutPoultry outPoultry) throws Exception {
        outPoultry.setId(id);
        if (outPoultryService.update(outPoultry)==1)
            return new Message("1","修改记录成功");
        else
            return new Message("2","修改记录失败");
    }

    /**
     * 展示一条记录
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public OutPoultry showOutPoultry(@PathVariable String id) throws Exception {
        return outPoultryService.get(id);
    }


    /**
     * 分页展示所有记录
     * @param outPoultry
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<OutPoultry> listOutPoultry(OutPoultry outPoultry, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<OutPoultry> outPoultryList =  outPoultryService.findList(outPoultry);
        //  返回 pageBean
        return new PageInfo<OutPoultry>(outPoultryList);
    }

    /**
     * 查找出养殖完成可以出厂的批次号
     * @param
     * @param
     * @return outPoultryList
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("listpatch")
    public List<String> Listname(String id_poultry) throws Exception {
        //  通过服务层获取查询后的用户列表
        //将返回的值放在ArrayList里面，以Outstorage模板呈现，没有的字段为null
        List<String> outPoultryList =  new ArrayList<String>(outPoultryService.findOutpoultry(id_poultry));
        //  返回 pageBean实体
        return outPoultryList;
    }
}
