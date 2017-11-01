package cn.zhku.waterfowl.modules.fowlery.controller;

import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
import cn.zhku.waterfowl.pojo.entity.Fowler;
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
    FowleryService fowleryService;

    /**
     * 添加一个鸡舍
     * @param fowlery
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("new")
    public int addFowlery(Fowler fowlery) throws Exception {
        fowlery.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        return fowleryService.add(fowlery);
    }

    /**
     * 删除鸡舍
     * @param id
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("delete")
    public int deleteFowlery(@PathVariable String id) throws Exception {
        Fowler fowlery=new Fowler();
        fowlery.setId(id);
       return fowleryService.delete(fowlery);
    }

    /**
     * 展示鸡舍
     * @param id
     * @return 鸡舍对象
     */
    @ResponseBody
    @RequestMapping("show/{id}")
    public Fowler showFowlery(@PathVariable String id) throws Exception {
        return fowleryService.get(id);
    }

    /**
     * 修改鸡舍信息
     * @param id
     * @param fowlery
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("edit/{id}")
    public int editFowlery(@PathVariable String id, Fowler fowlery) throws Exception {
        fowlery.setId(id);
        return fowleryService.update(fowlery);
    }


    /**
     * 多条件查询展示鸡舍
     * @param fowlery
     * @param commonQo
     * @return  鸡舍列表信息
     */
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<Fowler> listFowlery(Fowler fowlery, CommonQo commonQo) throws Exception {
        //设置页码
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),"id desc");
        //通过服务层获取鸡舍列表
        List<Fowler> fowleryList = fowleryService.findList(fowlery);
        //返回pagebean对象
        return new PageInfo<Fowler>(fowleryList);
    }

}
