package cn.zhku.waterfowl.modules.Affiliation.controller;

import cn.zhku.waterfowl.modules.Affiliation.model.AffiliationExcel;
import cn.zhku.waterfowl.modules.Affiliation.model.AffiliationUtilExcel;
import cn.zhku.waterfowl.modules.Affiliation.service.AffiliationService;
import cn.zhku.waterfowl.modules.fowlery.service.FowleryService;
import cn.zhku.waterfowl.pojo.entity.Affiliation;
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
     * 禽舍规格
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
    public Message addAffiliation(Affiliation affiliation) throws Exception {
        //  从shrio Session中获取user的session,填充记录员的字段
        affiliation.setIdRecord(SessionUtil.getUserSession().getId());

        affiliation.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if (affiliation.getStatus()==null||affiliation.getStatus().isEmpty()){
            affiliation.setStatus("未满员");
        }
        if (affiliation.getName()==null||affiliation.getName().isEmpty()){
            return new Message("3","添加失败，请填写大禽舍编号");
        }
        else if(affiliationService.add(affiliation)==1){
           return new Message("1","添加成功");
        }else{
            return new Message("0","添加失败");
        }
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
    public Message editAffiliation(@PathVariable String id, Affiliation affiliation) throws Exception {
        affiliation.setId(id);
        if( affiliationService.update(affiliation)==1){
            return new Message("1","修改禽舍成功");
        }else{
            return new Message("0","修改禽舍失败");
        }
    }

    /**
     * 通过id删除大禽舍
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteAffiliation/{id}")
    public Message deleteAffiliation(@PathVariable String id) throws Exception {
        Affiliation affiliation=new Affiliation();
        affiliation.setId(id);
        if(affiliationService.delete(affiliation)==1){
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

                AffiliationUtilExcel affiliationUtilExcel = new AffiliationUtilExcel(newFile.toString());
                //userExcelUtil.setEntityMap();
                Map<Integer, AffiliationExcel> affiliationExcelMap = affiliationUtilExcel.getMap();
                if (affiliationExcelMap == null)
                    return new Message("2", "物资导入失败，请检查excel表与模板的不同");
                //  java8 lambda遍历
                affiliationExcelMap.forEach((key, value) -> {
                    //  复制UserExcel对象到user类中
                    Affiliation affiliation=new Affiliation();
                    BeanUtils.copyProperties(value, affiliation);
                    affiliation.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                    try {
                        affiliationService.add(affiliation);
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
    public ResponseEntity<byte[]> pushExcel(Affiliation affiliation ) throws Exception {
        ExportExcelUtil<Affiliation> exportExcelUtil = new ExportExcelUtil<>();

        List<Affiliation> affiliationList = affiliationService.findList(affiliation);
        String[] headers = {"归属表编号", "类型", "地址", "规格", "状态" , "记录者编号", "负责人编号"};
        return exportExcelUtil.exportXLSXOutput("归属表", headers, affiliationList);
    }
}