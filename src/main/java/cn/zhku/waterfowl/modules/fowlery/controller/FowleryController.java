package cn.zhku.waterfowl.modules.fowlery.controller;

import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
import cn.zhku.waterfowl.pojo.entity.Fowlery;
import cn.zhku.waterfowl.util.modle.CommonQo;
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
 * Created by jin on 2017/10/24.
 */
@Controller
@RequestMapping("{adminPath}/fowlery/")
public class FowleryController {
    @Autowired
    FowleryService fowleryService;    //小禽舍


    /**
     * 通过禽舍的id查找小禽舍
     * @param id
     * @return 鸡舍对象
     */
    @ResponseBody
    @RequestMapping("showFowlery/{id}")
    public Fowlery showFowlery(@PathVariable String id) throws Exception {
        return fowleryService.get(id);
    }

    /**
     * 多条件查询展示小禽舍
     * @param fowlery
     * @param commonQo
     * @return  鸡舍列表信息
     */
    @ResponseBody
    @RequestMapping("listFowlery")
    public PageInfo<Fowlery> listFowlery(Fowlery fowlery, CommonQo commonQo) throws Exception {
        //设置页码
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),"id desc");
        //通过服务层获取鸡舍列表
        List<Fowlery> fowleryList = fowleryService.findList(fowlery);
        //返回pagebean对象
        return new PageInfo<Fowlery>(fowleryList);
    }


    /**
     * 添加一个小禽舍，禽舍的id由UUID产生
     * @param fowlery
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("newFowlery")
    public int addFowlery(Fowlery fowlery) throws Exception {
        fowlery.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        return fowleryService.add(fowlery);
    }


    /**
     *  修改小禽舍信息
     * @param id
     * @param fowlery
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("editFowlery/{id}")
    public int editFowlery(@PathVariable String id, Fowlery fowlery) throws Exception {
        fowlery.setId(id);
        return fowleryService.update(fowlery);
    }


    /**
     * 删除小 禽舍
     * @param id
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("deleteFowlery/{id}")
    public int deleteFowlery(@PathVariable String id) throws Exception {
        Fowlery fowlery=new Fowlery();
        fowlery.setId(id);
       return fowleryService.delete(fowlery);
    }

    /**
     * 确定fowlery的状态
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFowlryStatus/{id}")
    public String selectFowleryStatus(@PathVariable String id){
        String outpoultryid=fowleryService.selectFowleryStatus(id);

        //判断
        if(outpoultryid==null){
            return "1";        //不可使用
        }else{
            return "0";       //可使用
        }
    }
}
