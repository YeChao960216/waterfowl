package cn.zhku.waterfowl.modules.aquaculture.controller;


import cn.zhku.waterfowl.modules.aquaculture.dao.AquacultureDao;
import cn.zhku.waterfowl.modules.aquaculture.model.FeedWeight;
import cn.zhku.waterfowl.modules.aquaculture.service.AquacultureService;
import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.modules.outStorage.service.OutStorageService;
import cn.zhku.waterfowl.modules.patch.service.PatchService;
import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.entity.Patch;
import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.util.SessionUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.util.modle.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.WhileNode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 成君
 * @date 21:28 2017/11/18 0018
 * @E-mail 943193747@qq.com
 */
@Controller
@RequestMapping("/aquaculture")
public class AquacultureController{
    @Autowired
    AquacultureService aquacultureService;
    @Autowired
    OutStorageService outStorageService;
    @Autowired
    PatchService patchService;
    @Autowired
    AquacultureDao aquacultureDao;

    /**
     * 增加记录
     * @param aquaculture
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addAquaculture(Aquaculture aquaculture) throws Exception {
        //  从shrio Session中获取user的session,填充记录员的字段
        aquaculture.setIdRecorder(SessionUtil.getUserSession().getId());
        aquaculture.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置记录id
        Timestamp t = new Timestamp(System.currentTimeMillis());
        aquaculture.setRecordDate(t);
        float a=outStorageService.checkQuantity(aquaculture);
        if(a<aquaculture.getFeedWeight()){
            return new Message("3", "饲料剩余量不足");
        }
        else if(aquacultureService.add(aquaculture)==1) {
            outStorageService.manageOutstorage(aquaculture);
            if (aquaculture.getStatus().equals(30003)){
                Patch patch=patchService.get(aquaculture.getIdPatch());
                patch.setStatus("30003");
                patchService.update(patch);
            }
            return new Message("1", "成功增加1条记录");
        }
        else {
            return new Message("2","增加记录失败");}
    }
    /**
     * 删除记录
     * @param id
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deleteAquaculture(@PathVariable String id) throws Exception {
        Aquaculture aquaculture = new Aquaculture();
        aquaculture.setId(id);
        if (aquacultureService.delete(aquaculture)==1)
            return new Message("1","成功删除1条记录");
        else
            return new Message("2","删除记录失败");
    }

    /**
     * 修改记录
     * @param id
     * @param aquaculture
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editAquaculture(@PathVariable String id,Aquaculture aquaculture) throws Exception {
        aquaculture.setId(id);
        if (aquacultureService.update(aquaculture)==1)
            return new Message("1","修改记录成功");
        else
            return new Message("2","修改记录失败");

    }

    /**
     * 展示一条记录
     * @param id
     * @return aquaculture
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Aquaculture showAquaculture(@PathVariable String id) throws Exception {
        return aquacultureService.get(id);
    }


    /**
     * 分页展示所有记录
     * @param aquaculture
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<Aquaculture> listAquaculture(Aquaculture aquaculture, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<Aquaculture> aquacultureList = aquacultureService.findList(aquaculture);
        //  返回 pageBean
        return new PageInfo<Aquaculture>(aquacultureList);
    }

    /**
     *校验饲料重量
     * @param entity
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("checkQuantity")
    public List<Outstorage> checkQuantity(Aquaculture entity) throws Exception {
        return outStorageService.showQuantity(entity);
    }

    /**
     *  计算相同批次的小于指定name的养殖记录的feedWeight， weight
     * @param aquaculture 参数：name   idPatch
     * @return FeedWeight
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("showWeight")
    public List<FeedWeight> weight(Aquaculture aquaculture) throws Exception {
        int name = Integer.parseInt(aquaculture.getName());
        return aquacultureDao.feedWeight(name,aquaculture.getIdPatch());
    }

}
