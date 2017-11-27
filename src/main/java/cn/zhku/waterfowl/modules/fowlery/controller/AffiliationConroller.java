package cn.zhku.waterfowl.modules.fowlery.controller;

import cn.zhku.waterfowl.modules.fowlery.service.AffiliationService;
import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
import cn.zhku.waterfowl.pojo.entity.Affiliation;
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
 * Created by jin on 2017/11/16.
 */
@Controller
@RequestMapping("{adminPath}/affiliation/")
public class AffiliationConroller {
    @Autowired
    AffiliationService affiliationService;    //大禽舍
    @Autowired
    FowleryService fowleryService;      //小禽舍

    /**
     * 通过id查找大禽舍,前端需要修改与数据字典中有关的数据
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("showAffiliation/{id}")
    public Affiliation showAffiliation(@PathVariable String id) throws Exception {
        return affiliationService.get(id);
    }

    /**
     * 多条件 查询
     * @param affiliation
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("listAffiliation")
    public PageInfo<Affiliation> listAffiliation(Affiliation affiliation,CommonQo commonQo) throws Exception {
        //设置页码
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),  "id desc");
        //通过服务层获取禽舍列表
        List<Affiliation> affiliationList=affiliationService.findList(affiliation);
        //返回pagebean对象
        return new PageInfo<Affiliation>(affiliationList);
    }

    /**
     * 禽舍的大小，前端需要改数据字典相应的name
     * @return
     */
    @ResponseBody
    @RequestMapping("selectSize")
    public List<String> selectSize(){
        return affiliationService.selectSize();
    }

    /**
     * 禽舍地址,前端需要改数据字典相应的name
     * @return
     */
    @ResponseBody
    @RequestMapping("selectPosition")
    public List<String> selectPosition(){
        return affiliationService.selectPosition();
    }

    /**
     * 查找禽舍类型，前端需要改数据字典相应的name
     * @return
     */
    @ResponseBody
    @RequestMapping("selectType")
    public List<String> selectType(){
        return affiliationService.selectType();
    }

    /**
     * 添加一个大禽舍
     * @param affiliation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("newAffiliation")
    public int addAffiliation(Affiliation affiliation) throws Exception {
        affiliation.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        return affiliationService.add(affiliation);
    }

    /**
     * 通过id修改大禽舍
     * @param id
     * @param affiliation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("editAffiliation/{id}")
    //URl:http://localhost:8080/waterfowl/admin/affiliation/editAffiliation/1?type=70001
    public int editAffiliation(@PathVariable String id, Affiliation affiliation) throws Exception {
        affiliation.setId(id);
        return affiliationService.update(affiliation);
    }

    /**
     * 通过id删除大禽舍
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteAffiliation/{id}")
    public int deleteAffiliation(@PathVariable String id) throws Exception {
        Affiliation affiliation=new Affiliation();
        affiliation.setId(id);
        return affiliationService.delete(affiliation);
    }
}