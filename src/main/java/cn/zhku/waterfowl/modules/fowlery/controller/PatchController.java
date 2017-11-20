package cn.zhku.waterfowl.modules.fowlery.controller;

import cn.zhku.waterfowl.modules.fowlery.service.PatchService;
import cn.zhku.waterfowl.pojo.entity.Affiliation;
import cn.zhku.waterfowl.pojo.entity.Fowlery;
import cn.zhku.waterfowl.pojo.entity.Patch;
import cn.zhku.waterfowl.util.modle.CommonQo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jin on 2017/11/17.
 */
@Controller
@RequestMapping("{adminPath}/patch/")
public class PatchController {
    @Autowired
    PatchService patchService;    //批次号

    /**
     * 通过id展示批次列表
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("showPatch/{id}")
    public Patch showPatch(@PathVariable String id) throws Exception {
        return patchService.get(id);
    }

    /**
     * 多条件查询
     * @param patch
     * @param commonQo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("listPatch")
    public PageInfo<Patch> listPatch(Patch patch, CommonQo commonQo) throws Exception {
        //设置页码
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),"id desc");
        //通过服务层获取批次列表
        List<Patch> patchList=patchService.findList(patch);
        //返回pagebean对象
        return new PageInfo<Patch>(patchList);
    }


    /**
     * 修改批次
     * @param id
     * @param patch
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("editPatch")
    public int editPatch(@PathVariable String id,Patch patch) throws Exception {
        patch.setId(id);
        return patchService.update(patch);
    }

    /**
     * 删除批次
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deletePatch/{id}")
    public int deletePatch(@PathVariable String id) throws Exception {
        Patch patch=new Patch();
        patch.setId(id);
        return patchService.delete(patch);
    }


    /**
     * 生成禽兽的批次号
     * 通过数据库的字段拼接
     * 通过patch的id获取该批次，然后将批次拼接起来
     * @return
     */
    @ResponseBody
    @RequestMapping("getPatch/{id}")
    public String getPatch(@PathVariable String id) throws Exception {
        //通过id找到该批次
        Patch patch=new Patch();
        patch.setId(id);
        patch = patchService.get(id);     //通过id获取批次
        String pat=patch.getIdPoultry()+patch.getType()+patch.getPosition()+patch.getSize()
                +patch.getIdAffilation()+patch.getIdFowlery();
        return pat;
    }


    /**
     * 通过type,position,size去选取大禽舍
     * @param type
     * @param position
     * @param size
     * @return  没有被使用完的归属表集合
     */
    @ResponseBody
    @RequestMapping("selectAffliation")
    public List<Affiliation> selectAffiliation(@PathVariable  String type,String position,String size){
        Affiliation affiliation=new Affiliation();

        affiliation.setType(type);
        affiliation.setPosition(position);
        affiliation.setSize(size);

        List<Affiliation> affiliationList=patchService.selectAffiliation(type,position,size);

        //如果该归属表是还没有被使用的话
        for(int i=0;i<affiliationList.size();i++){
            //返回那些没有被使用完的
            if(affiliationList.get(i).getStatus().equals("1")){
                affiliationList.remove(i);      //如果归属表被使用了，移除
            }
        }

        return affiliationList;
    }


    /**
     * 根据选好的归属表去确定小禽舍
     * @param affiliation
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFowlery/{affiliation}")
    public List<Fowlery> selectFowlery(@PathVariable String affiliation){
        Fowlery fowlery=new Fowlery();
        fowlery.setAffiliation(affiliation);

        List<Fowlery> fowleryList=patchService.selectFowlery(affiliation);
        System.out.print(affiliation);
        for(int i=0;i<fowleryList.size();i++){
            if(fowleryList.get(i).getStatus().equals("1")){
                //该小禽舍被使用了
                fowleryList.remove(i);
            }
        }

        return  fowleryList;     //返回一个没有被使用的小禽舍集合
    }


    /*
    用于判断是否还可以再选
     */
    @ResponseBody
    @RequestMapping("isFull/{id_poultry}")
    public int IsFull(@PathVariable String id_poultry){

        //通过id_poultry得到总数
        String quantity=patchService.getCount(id_poultry);
        int sum=Integer.parseInt(quantity);     //转换成string类型

        //直接查表，在patch表中查找那些poultry的fowlery，一个集合,我们可以获取一个status集合，然后查看他们的大小,而且要通过数据字典，计算他们的和
        List<String> sizeList=patchService.getFowlerySize(id_poultry);

        //遍历集合，达到结果后去查询数据字典，再相加
        int su=0;
        for(int i=0;i<sizeList.size();i++){
            String size=patchService.selectSizeByDic(sizeList.get(i));

            int s=Integer.parseInt(size);    //解析

            su=su+s;   //求和
        }

        if(sum>su){
            return 1;   //可继续查找
        }else{
            return 0;    //不能继续查找
        }
    }
}
