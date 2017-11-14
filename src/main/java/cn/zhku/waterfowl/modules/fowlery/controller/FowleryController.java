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
    @RequestMapping("delete/{id}")
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

    //一个鸡舍种类的接口,通过type查找id
    @ResponseBody
    @RequestMapping("list/{type}")
    public String listFowleryType(@PathVariable String type){

        return fowleryService.getType(type);
    }

    /**
     * 判断个数是否超过禽舍的最大数
     * @param id
     * @param sum  前端的数量
     * @return 1:可以使用，0：不能使用
     */
    @ResponseBody
    @RequestMapping("findMaxNum/{id}")
    public int IsOverMaxNum(@PathVariable String id, Integer sum){
        Integer maxnum=fowleryService.findMaxNumById(id);
        if(maxnum>=sum){
            return 1;            //小于数据库中查询到的最大数，可以使用
        }else{
            return 0;             //大于数据库中查询到的最大数，不能使用
        }
    }

    /**
     * 禽舍剩余的数量
     * @param id
     * @return 可用数量
     */
    @ResponseBody
    @RequestMapping("findSpace/{id}")
    public int FindSpaceById(@PathVariable String id){
        //禽舍可以存放的最大数量
        Integer maxnum= fowleryService.findMaxNumById(id);
        //禽舍已经被存放的数量
        Integer num=fowleryService.findUsedNumById(id);
        if(maxnum>num){
            //可以存放的数量
            Integer ableuse=maxnum-num;
            return ableuse;
        }else{
            return 0;
        }
    }
}
