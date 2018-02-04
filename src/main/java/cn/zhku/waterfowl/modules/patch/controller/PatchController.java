package cn.zhku.waterfowl.modules.patch.controller;

        import cn.zhku.waterfowl.modules.Affiliation.service.AffiliationService;
        import cn.zhku.waterfowl.modules.patch.service.PatchService;
        import cn.zhku.waterfowl.modules.poultry.service.PoultryService;
        import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
        import cn.zhku.waterfowl.pojo.entity.Affiliation;
        import cn.zhku.waterfowl.pojo.entity.Fowlery;
        import cn.zhku.waterfowl.pojo.entity.Patch;
        import cn.zhku.waterfowl.util.SessionUtil;
        import cn.zhku.waterfowl.util.modle.CommonQo;
        import cn.zhku.waterfowl.util.modle.Message;
        import cn.zhku.waterfowl.util.modle.Msg;
        import com.github.pagehelper.PageHelper;
        import com.github.pagehelper.PageInfo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.sql.Timestamp;
        import java.text.SimpleDateFormat;
        import java.util.*;

/**
 * Created by jin on 2017/11/17.
 */
@Controller
@RequestMapping("{adminPath}/patch/")
public class PatchController {
    @Autowired
    PatchService patchService;    //批次号
    @Autowired
    AffiliationService affiliationService;
    @Autowired
    private PoultryService poultryService;
    @Autowired
    private FowleryService flowleryService;

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
    @RequestMapping("editPatch/{id}")
    public Message editPatch(@PathVariable String id, Patch patch) throws Exception {
        patch.setId(id);
        if(patchService.update(patch)==1){
            return new Message("1","修改批次成功");
        }else{
            return new Message("0","修改批次失败");
        }
    }

    /**
     * 删除批次
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deletePatch/{id}")
    public Message deletePatch(@PathVariable String id) throws Exception {
        Patch patch=new Patch();
        patch.setId(id);
        if(patchService.delete(patch)==1){
            return new Message("1","删除批次成功");
        }else{
            return new Message("0","修改批次失败");
        }
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
     * 增加一条记录
     * @return
     */
    /*
    *   gonefuture修改于2018/1/15 19：05
     */
    @ResponseBody
    @RequestMapping("newPatch")
    public Message addPatch( Patch patch) throws Exception {
        //  从shrio Session中获取user的session,填充记录员的字段
        patch.setIdRecorder(SessionUtil.getUserSession().getId());
        Timestamp t = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String a=sdf.format(t);
        patch.setId(poultryService.get(patch.getIdPoultry()).getAssociatedFirm()+patch.getIdAffilation()+patch.getIdFowlery()+a);
        patch.setDate(t);
        Fowlery fowlery=new Fowlery();
        fowlery.setAffiliation(patch.getIdAffilation());
        fowlery.setName(patch.getIdFowlery());
        if (flowleryService.findList(fowlery).get(0).getStatus().equals("不可使用")){
            return new Message("3","选取的禽舍已使用");
        }
        else if (patchService.add(patch) == 1) {
            flowleryService.findList(fowlery).get(0).setStatus("不可使用");
            flowleryService.update(flowleryService.findList(fowlery).get(0));
            return new Message("1","增加分批记录成功");
        } else {
            return new Message("2","增加分批记录失败");
        }
    }

    /**
     * 通过type,position去选取大禽舍
     * @return  没有被使用完的归属表集合
     */
    @ResponseBody
    @RequestMapping("selectAffliation")
    public List<Affiliation> selectAffiliation(Affiliation affiliation){
        //前端输进来的是数据字典的name的字段，我们要保存的是数据字典中的id
        List<Affiliation> affiliationList=new ArrayList<>(affiliationService.selectAffiliation(affiliation.getType(),affiliation.getPosition()));
        //如果该归属表是还没有被使用的话
/*        for(int i=0;i<affiliationList.size();i++){
            //返回那些没有被使用完的
            if(affiliationList.get(i).getStatus().equals("满员")){
                affiliationList.remove(i);      //如果归属表被使用了，移除
            }
        }
        叶超改动了这里的代码，底层刷选已经完成该工作*/
        return affiliationList;
    }


    /**
     * 根据选好的归属表去确定小禽舍
     * @return
     */
    @ResponseBody
    @RequestMapping("selectFowlery")
    public List<Fowlery> selectFowlery(Fowlery fowlery){
        List<Fowlery> fowleryList=new ArrayList<>(patchService.selectFowlery(fowlery.getAffiliation()));
//        for(int i=0;i<fowleryList.size();i++){
//            if(fowleryList.get(i).getStatus().equals("不可使用")){
//                //该小禽舍被使用了
//                fowleryList.remove(i);
//            }
//        }
        return  fowleryList;     //返回一个没有被使用的小禽舍集合
    }


    /**
     * 根据被选择的小禽舍去修改状态
     * @param id 小禽舍的id
     * @return
     */
    @ResponseBody
    @RequestMapping("updateStatusByid/{id}")
    public int updateStatusByid(@PathVariable String id){
        //修改小禽舍的状态
        int i=patchService.updateStatusByid(id);
        return i;
    }

    /**
     * 获取禽舍中最新的批次号
     * @return
     */
    @ResponseBody
    @RequestMapping("getNewPatch")
    public  String getNewPatch() throws Exception {
        Patch patch;
        String id= patchService.getNewPatch();
        patch=patchService.get(id);

        return patch.getIdPoultry()+patch.getType()+patch.getPosition()+patch.getSize()
                +patch.getIdAffilation()+patch.getIdFowlery();

    }

    /**
     * 通过id_poultry找到patch的id集合
     * @return
     */
    @ResponseBody
    @RequestMapping("findPatchByPid/{id_poultry}")
    public Msg findPatch(@PathVariable String id_poultry) throws Exception {
//        List<String> list= new ArrayList<String>();
//        list = patchService.findPatch(id_poultry);
        Patch patch = new Patch();
        patch.setStatus("30002");
        patch.setIdPoultry(id_poultry);
        List<Patch> patchList = patchService.findList(patch);

        Msg msg = new Msg("1","查找成功","200",patchList);
        return msg;
    }


    /**
     * 通过id_poultry和status找到patch的id集合
     * @return
     */
    @ResponseBody
    @RequestMapping("findPatchByPidAndStatus/{id_poultry}")
    public Msg findPatchByPidAndStatus(@PathVariable String id_poultry,Patch patch) throws Exception {
        patch.setIdPoultry(id_poultry);
        List<Patch> patchList = patchService.findList(patch);

        Msg msg = new Msg("1","查找成功","200",patchList);
        return msg;
    }

    /**
     * 通过id_poultry和status找到patch的id集合,分页版本
     * @return
     */
    @ResponseBody
    @RequestMapping("findPatchByPidAndStatusCutPage/{id_poultry}")
    public PageInfo<Patch> findPatchByPidAndStatusCutPage(@PathVariable String id_poultry,Patch patch,CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),"date desc");
        patch.setIdPoultry(id_poultry);
        List<Patch> patchList = patchService.findList(patch);
        return new PageInfo<Patch>(patchList);
    }

    List<String> findByPatch( String id_poultry){
        List<String> list= new ArrayList<String>();
        list = patchService.findPatch(id_poultry);
        return list;
    }


    /**
     * 判断该批次是否都放进去禽舍里
     * @param id_poultry
     * @return
     */
    @ResponseBody
    @RequestMapping("isEqualSum/{id_poultry}")
    public Msg IsEqualSum(@PathVariable String id_poultry) throws Exception {
//        List list=findByPatch(id_poultry);   //调用上面的方法找到patch的所有id
//        int sum=0;   //放在禽舍中的总数量
//        for(int i=0;i<list.size();i++){
//            String st=patchService.findSize((String) list.get(i));    //每一个禽舍的存放的数量
//            int s=Integer.parseInt(st);        //将string类型转换成int类型
//            sum+=s;           //总数
//        }

        // 218-1-13 21:52 修改 qwj
        int sum=0;   //放在禽舍中的总数量
        Patch patch = new Patch();
        patch.setIdPoultry(id_poultry);
        List<Patch> patchList =patchService.findList(patch);
        for(Patch patchEntitty:patchList) {
            sum += patchEntitty.getSize();
        }
        String totals=patchService.findQuantity(id_poultry);   //poultry中的总数量
        int totalsum=Integer.parseInt(totals);     //将string类型转换成int类型
        int extrasum=totalsum-sum;
        return new Msg("1","成功","200",extrasum);
    }


}