package cn.zhku.waterfowl.modules.aquaculture.controller;


import cn.zhku.waterfowl.modules.aquaculture.model.FeedWeight;
import cn.zhku.waterfowl.modules.aquaculture.service.AquacultureService;
import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.modules.outStorage.service.OutStorageService;
import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.util.modle.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.WhileNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    OutStorageDao outStorageDao;

    /**
     * 增加记录
     * @param aquaculture
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addAquaculture(Aquaculture aquaculture) throws Exception {
        aquaculture.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置记录id
        float a=aquacultureService.checkQuantity(aquaculture);
        if(a<aquaculture.getFeedWeight()){
            return new Message("3", "饲料剩余量不足");
        }
        else if(aquacultureService.add(aquaculture)==1) {
            outStorageService.manageOutstorage(aquaculture.getFeedType(),aquaculture.getRemark(),aquaculture.getFeedWeight());
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
    public List<Outstorage> editOutstorage(Aquaculture entity) throws Exception {
        float quantity=entity.getFeedWeight();
        float num=aquacultureService.checkQuantity(entity);

        if(quantity>num) {
            Outstorage outstorage=new Outstorage();
            outstorage.setRest(num);
            List<Outstorage> outstorageList = new ArrayList<Outstorage>();
            outstorageList.add(outstorage);
            return outstorageList;
        }
        else{
            List<Outstorage> outstoragelist=new ArrayList<Outstorage>(outStorageDao.manageOutstorage(entity.getFeedType(),entity.getRemark(),quantity));
            //定义两个float变量sum，表示累加数;temp为定值float的0
            float sum=0;
            //开始进入循环体
            for (int i=0;i<outstoragelist.size();i++){
                //将每个记录的剩余量取出来
                float a=outstoragelist.get(i).getRest();
                //进行累加
                sum+=a;
                //如果累加的结果与所需要的量quantity相等
                if(sum==quantity) {
                    //进行循环体
                    for (int k=outstoragelist.size()-1;k>i;k--){
                        //将符合条件的记录取出来
                        outstoragelist.remove(k);
                    }
                    //结束上一层循环体，即跳出循环
                    break;
                }
                //如果累加的结果大于所需要的量quantity
                if(sum>quantity) {
                    //将符合条件的但是仍有剩余量的记录取出来
//                    Outstorage less=outstoragelist.get(i);
//                    //将更改后的记录放到数据库
//                    outstorageMapper.updateByPrimaryKeySelective(less);
                    //进行循环体
                    for (int k=outstoragelist.size()-1;k>i;k--){
                        //将符合记录但是没有剩余量的记录取出来
                        outstoragelist.remove(k);
                    }
                    outstoragelist.get(i).setRest(outstoragelist.get(i).getRest()-sum+quantity);
                    //结束上一层循环体，即跳出循环

                    break;
                }
            }
            return outstoragelist;
    }
    }

    @ResponseBody
    @RequestMapping("listremark")
    public List<Outstorage> listOutstorageByname(String name) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        return aquacultureService.listOutstorageByname(name);
    }

    @ResponseBody
    @RequestMapping("listid")
    public List<Outstorage> listOutstorageid(String name,String remark) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        return aquacultureService.listOutstorageid(name,remark);
    }

    /**
     *  计算相同批次的小于指定name的养殖记录的feedWeight， weight
     * @param aquaculture 参数：name   idPatch
     * @return FeedWeight
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("showWeight")
    public FeedWeight weight(Aquaculture aquaculture) throws Exception {
        return aquacultureService.showWeight(aquaculture);
    }


}
