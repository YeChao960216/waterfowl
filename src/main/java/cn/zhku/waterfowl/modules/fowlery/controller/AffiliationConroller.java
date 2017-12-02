package cn.zhku.waterfowl.modules.fowlery.controller;

import cn.zhku.waterfowl.modules.fowlery.service.AffiliationService;
import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
import cn.zhku.waterfowl.pojo.entity.Affiliation;
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
 * Created by jin on 2017/11/16.
 */
@Controller
@RequestMapping("{adminPath}/affiliation/")
public class  AffiliationConroller {
    @Autowired
    AffiliationService affiliationService;    //大禽舍
    FowleryService fowleryService;      //小禽舍

    /**
     * 通过id查找大禽舍
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
     * 多条件查询n
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


    /**
     * 确定affiliation的状态
     * @param id
     * @return affiliation
     */
    @ResponseBody
    @RequestMapping("selectStatus/{id}")
    public Affiliation selectStatusByFowlery(@PathVariable String id) {
        Affiliation affiliation=new Affiliation();
        affiliation.setId(id);

        Fowlery fowlery = new Fowlery();
        fowlery.setAffiliation(id);

        //通过affiliation的id查找到fowlery
        List<Fowlery> fowleryList = fowleryService.findFowleryByAId(id);

        //判断fowlery的状态是否都是0，如果是，则归属表的状态也是0，如果不是，则状态为1
        String status = null;
        for (int i = 0; i < fowleryList.size(); i++) {
            if (fowleryList.get(i).getStatus().equals('1')) {
                //如果都是1，表示小禽舍都满员
                status="1";             //1表示不可使用
            } else {
                status="0";             //0，可以使用
            }
        }

        affiliation.setSize(status);

        return affiliation;
    }
}
