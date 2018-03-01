package cn.zhku.waterfowl.modules.manufacture.controller;

import cn.zhku.waterfowl.modules.manufacture.dao.ManufactureDao;
import cn.zhku.waterfowl.modules.manufacture.service.ManufactureService;
import cn.zhku.waterfowl.modules.outStorage.service.OutStorageService;
import cn.zhku.waterfowl.pojo.entity.Manufacture;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author 成君
 * @date  2018/1/24 2018/1/22 0022.
 * @E-mail 943193747@qq.com
 */

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;
    @Autowired
    ManufactureDao manufactureDao;

    /**
     * 增加记录
     * @param manufacture
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addManufacture(Manufacture manufacture) throws Exception {
        manufacture.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位大小的UUID来设置记录id
        Timestamp t = new Timestamp(System.currentTimeMillis());
        manufacture.setRecordDate(t);
        if (manufactureService.add(manufacture) == 1) {

            return new Message("1", "成功增加1条记录");
        } else {
            return new Message("2", "增加记录失败");
        }
    }

    /**
     * 删除记录
     *
     * @param id
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message deleteManufacture(@PathVariable String id) throws Exception {
        Manufacture manufacture = new Manufacture();
        manufacture.setId(id);
        if (manufactureService.delete(manufacture) == 1)
            return new Message("1", "成功删除1条记录");
        else
            return new Message("2", "删除记录失败");
    }

    /**
     * 修改记录
     *
     * @param id
     * @param manufacture
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message editManufacture(@PathVariable String id, Manufacture manufacture) throws Exception {
        manufacture.setId(id);
        if (manufactureService.update(manufacture) == 1)
            return new Message("1", "修改记录成功");
        else
            return new Message("2", "修改记录失败");

    }

    /**
     * 展示一条记录
     * @param id
     * @return manufacture
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Manufacture showManufacture(@PathVariable String id) throws Exception {
        return manufactureService.get(id);
    }


    /**
     * 分页展示所有记录
     *
     * @param manufacture
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<Manufacture> listManufacture(Manufacture manufacture, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<Manufacture> manufactureList = manufactureService.findList(manufacture);
        //  返回 pageBean
        return new PageInfo<Manufacture>(manufactureList);
    }

    /**
     *
     * @param idPatch
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("finishManufacture")
    public Message setPatchStatusToTrans(String idPatch) throws Exception{
        if (manufactureDao.setPatchStatusToTrans(idPatch) > 0) {
            return new Message("1", "修改成功");
        } else {
            return new Message("2", "修改失败");
        }
    }
}