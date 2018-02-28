package cn.zhku.waterfowl.modules.transportation.controller;


import cn.zhku.waterfowl.modules.outPoultry.servie.OutPoultryService;
import cn.zhku.waterfowl.modules.transportation.dao.TransportationDao;
import cn.zhku.waterfowl.modules.transportation.service.TransportationService;
import cn.zhku.waterfowl.pojo.entity.*;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author 成君
 * @date  2018/1/24 2018/1/23 0022.
 * @E-mail 943193747@qq.com
 */
@Controller
@RequestMapping("/transportation")
public class TranspotationController {

    @Autowired
    TransportationService transportationService;
    @Autowired
    TransportationDao transportationDao;

    @Autowired
    OutPoultryService outPoultryService;

    /**
     * 增加记录
     * @param transportation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addTransportation(Transportation transportation) throws Exception {
        transportation.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位大小的UUID来设置记录id
        Timestamp t = new Timestamp(System.currentTimeMillis());
        transportation.setCurdate(t);

        OutPoultry outPoultry = new OutPoultry();
        outPoultry.setStatus("30008");
        outPoultry.setId(transportation.getIdPatch());


        if (transportationService.add(transportation) == 1 && outPoultryService.update(outPoultry) == 1) {

            return new Message("1", "成功增加1条记录");
        } else {
            return new Message("2", "增加记录失败");
        }
    }

    /**
     * 删除记录
     * @param id
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deleteTransportation(@PathVariable String id) throws Exception {
        Transportation transportation = new Transportation();
        transportation.setId(id);
        if (transportationService.delete(transportation) == 1)
            return new Message("1", "成功删除1条记录");
        else
            return new Message("2", "删除记录失败");
    }

    /**
     * 修改记录
     * @param id
     * @param transportation
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editTransportation (@PathVariable String id, Transportation transportation) throws Exception {
        transportation.setId(id);
        if (transportationService.update(transportation) == 1)
            return new Message("1", "修改记录成功");
        else
            return new Message("2", "修改记录失败");

    }

    /**
     * 展示一条记录
     * @param id
     * @return transportation
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Transportation showTransportation(@PathVariable String id) throws Exception {
        return transportationService.get(id);
    }


    /**
     * 分页展示运输记录表的所有记录
     *
     * @param transportation
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("listtransportation")
    public PageInfo<Transportation> listTransportation(Transportation transportation, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "curdate desc");
        //  通过服务层获取查询后的用户列表
        List<Transportation> transportationList = transportationService.findList(transportation);
        //  返回 pageBean
        return new PageInfo<Transportation>(transportationList);
    }

    /**
     * 完成运输
     * @param idPatch
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("finishTrans")
    public Message setPatchStatusToTrans(String idPatch) throws Exception{
        if (transportationDao.setPatchStatusFinish(idPatch) > 0) {

            return new Message("1", "修改成功");
        } else {
            return new Message("2", "修改失败");
        }
    }
}
