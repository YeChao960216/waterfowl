package cn.zhku.waterfowl.modules.fowlery.controller;

import cn.zhku.waterfowl.modules.fowlery.model.FowleryExcel;
import cn.zhku.waterfowl.modules.fowlery.model.FowleryUtilExcel;
import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
import cn.zhku.waterfowl.pojo.entity.Fowlery;
import cn.zhku.waterfowl.util.SessionUtil;
import cn.zhku.waterfowl.util.excel.ExportExcelUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
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
     * 添加一个小禽舍，禽舍的id由UUID产生？？？--需修改的部分
     * @param fowlery
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("newFowlery")
    public Message addFowlery(Fowlery fowlery) throws Exception {
        //  从shrio Session中获取user的session,填充记录员的字段
        fowlery.setIdRecord(SessionUtil.getUserSession().getId());

        fowlery.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if (fowlery.getStatus()==null||fowlery.getStatus().isEmpty()){
            fowlery.setStatus("可使用");
        }
        if (fowlery.getName()==null||fowlery.getName().isEmpty()){
            return new Message("3","添加禽舍失败，请填写禽舍编号");
        }
        else if(fowleryService.add(fowlery)==1){
            return new Message("1","添加禽舍成功");
        }else{
            return new Message("0","添加禽舍失败");
        }
    }


    /**
     *  修改小禽舍信息
     * @param id
     * @param fowlery
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("editFowlery/{id}")
    public Message editFowlery(@PathVariable String id, Fowlery fowlery) throws Exception {
        fowlery.setId(id);
        if(fowleryService.update(fowlery)==1){
            return new Message("1","修改禽舍成功");
        }else{
            return new  Message("0","修改禽舍失败");
        }
    }


    /**
     * 删除小禽舍
     * @param id
     * @return 状态码，1为成功，0为失败
     */
    @ResponseBody
    @RequestMapping("deleteFowlery/{id}")
    public Message deleteFowlery(@PathVariable String id) throws Exception {
        Fowlery fowlery=new Fowlery();
        fowlery.setId(id);
       if(fowleryService.delete(fowlery)==1){
           return new Message("1","删除禽舍成功");
       }else{
           return new Message("0","删除禽舍失败");
       }
    }


    /**
     * 导入用excel
     *
     * @param request   请求域
     * @param excelFile excel文件，前端用multipart/form-data类型上传
     * @return Msg
     */
    @ResponseBody
    @RequestMapping("excel/pull")

    public Message pullAffiliationExcel(HttpServletRequest request, MultipartFile excelFile) {
        try {
            if (excelFile != null || excelFile.getOriginalFilename().endsWith("xls") || excelFile.getOriginalFilename().endsWith("xlsx")) {
                //List<MaterialModel> models=userService.insertUserByExcel(excelFile);
                //  储存图片的物理路径
                String realPath = request.getServletContext().getRealPath("/WEB-INF/excel/material/");
                //  获取上传文件的文件类型名
                String originalFileName = excelFile.getOriginalFilename();
                //  新的的图片名称,用UUID做文件名防止重复
                String newFileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + originalFileName.substring(originalFileName.lastIndexOf("."));
                //新图片文件
                File newFile = new File(realPath + newFileName);
                //将内存中的数据写入磁盘
                excelFile.transferTo(newFile);
                //将新图片名称写到repair中
                //repair.setRepairPic(newFileName);

                FowleryUtilExcel fowleryUtilExcel = new FowleryUtilExcel(newFile.toString());
                //userExcelUtil.setEntityMap();
                Map<Integer, FowleryExcel> fowleryExcelMap = fowleryUtilExcel.getMap();
                if (fowleryExcelMap == null)
                    return new Message("2", "物资导入失败，请检查excel表与模板的不同");
                //  java8 lambda遍历
                fowleryExcelMap.forEach((key, value) -> {
                    //  复制UserExcel对象到user类中
                    Fowlery fowlery=new Fowlery();
                    BeanUtils.copyProperties(value, fowlery);
                    fowlery.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                    try {
                        fowleryService.add(fowlery);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                return new Message("1", "物资导入成功");
            } else {
                return new Message("2", "上传失败或者上传的文件后缀不是'xls'或'xlsx'");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("excel/push")
    public ResponseEntity<byte[]> pushExcel(Fowlery fowlery ) throws Exception {
        ExportExcelUtil<Fowlery> exportExcelUtil = new ExportExcelUtil<>();

        List<Fowlery> fowleryList = fowleryService.findList(fowlery);
        String[] headers = {"禽舍编号", "类型", "状态" , "归属表" ,  "记录者编号", "负责人编号"};
        return exportExcelUtil.exportXLSXOutput("禽舍表", headers, fowleryList);
    }

    /**
     * 禽舍中被使用的百分比
     * @return
     */
    @ResponseBody
    @RequestMapping("findPercentage")
    public double userdPercentage(){
        //查找所有禽舍的数量,count
        int totalsum=fowleryService.countAllFowlery();

        //查找所有被使用的数量
        int userdsum=fowleryService.countUsedFowlery();

        //获取被使用数量的百分比
        double userpercentage=userdsum/(totalsum*1.0);

        return userpercentage;
    }
}
