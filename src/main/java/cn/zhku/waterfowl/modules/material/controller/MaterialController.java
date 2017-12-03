package cn.zhku.waterfowl.modules.material.controller;

import cn.zhku.waterfowl.modules.material.model.MaterialExcel;
import cn.zhku.waterfowl.modules.material.model.MaterialUtilExcel;
import cn.zhku.waterfowl.modules.material.service.MaterialService;
import cn.zhku.waterfowl.pojo.entity.Material;
import cn.zhku.waterfowl.util.excel.ExportExcelUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author : 叶超 yc755909707@foxmail.com
 * @version : 2017/11/14 18:23.
 * 说明：
 */
@RestController
@RequestMapping("/material/")
public class MaterialController extends BaseController {
    @Autowired
    MaterialService materialService;

    /**
     * 增加一条数据
     *
     * @param material 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */
    @ResponseBody
    @RequestMapping("add")
    public Message addMaterial(Material material) throws Exception {
        material.setIdStorage(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位长度的UUID来设置用户id
        if (materialService.add(material) == 1)
            return new Message("1", "插入材料成功");
        else
            return new Message("2", "插入材料失败");

    }

    /**
     * 删除一条记录
     *
     * @param entity id 表主键
     * @return Message
     * 1     * @throws Exception   sql、bean检验
     */

    @ResponseBody
    @RequestMapping("delete/{id}")
    public Message delete(@PathVariable String id, Material entity) throws Exception {
        entity.setIdStorage(id);
        if (materialService.delete(entity) == 1)
            return new Message("1", "成功删除材料");
        else
            return new Message("2", "删除材料失败");
    }

    /**
     * @param entity 实体类
     * @return Message
     * @throws Exception sql、bean检验
     */

    @ResponseBody
    @RequestMapping("edit/{id}")
    public Message update(@PathVariable String id, Material entity) throws Exception {
        entity.setIdStorage(id);
        if (materialService.update(entity) == 1)
            return new Message("1", "更新材料信息成功");
        else
            return new Message("2", "更新材料信息失败");
    }

    /**
     * 获取一条记录
     *
     * @param id 表主键
     * @return Message
     * @throws Exception sql、bean检验
     */
    @ResponseBody
    @RequestMapping("select/{id}")
    public Material get(@PathVariable String id) throws Exception {
        return materialService.get(id);
    }

    /**
     * 获取一个分页的数据列表
     *
     * @param entity   实体类
     * @param commonQo 通用查询类
     * @return PageInfo分页类
     * @throws Exception sql、bean检验
     */
    /**
     * 根据多个条件展示一列用户 => 多条件查询分页
     *
     * @param material material实体的各个字段
     * @param commonQo 通用查询类，拥有pageSize,
     * @return PageInfo<OutStorage> 一个带有List<OutStorage>的pageBean
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("selectBy")
    public PageInfo<Material> select(Material material, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "date desc");
        //  通过服务层获取查询后的用户列表
        List<Material> materialList = materialService.findList(material);
        //  返回 pageBean实体
        return new PageInfo<Material>(materialList);
    }
    //分页展示出库记录

    @ResponseBody
    @RequestMapping("show")
    public PageInfo<Material> show(Material entity, CommonQo commonQo) throws Exception {
//        //  设置默认的排序，如果前端需要排训查询，则加上参数  sort = 数据库字段 ，
//        if (commonQo.getSort().equals("1"))  //字符串"1"是sort的默认值，相当于 order by 1 ,即按主键排序
//        commonQo.setSort("date desc");
//        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),commonQo.getSort());
//
//        return new PageInfo<>(materialService.list(entity,commonQo));
//    }
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "date desc");
        //  通过服务层获取查询后的用户列表
        List<Material> materialList = materialService.showAll(entity, commonQo);
        //  返回 pageBean实体
        return new PageInfo<Material>(materialList);
    }

    @ResponseBody
    @RequestMapping("list")
    public PageInfo<Material> list(Material entity, CommonQo commonQo) throws Exception {
//        //  设置默认的排序，如果前端需要排训查询，则加上参数  sort = 数据库字段 ，
//        if (commonQo.getSort().equals("1"))  //字符串"1"是sort的默认值，相当于 order by 1 ,即按主键排序
//        commonQo.setSort("date desc");
//        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),commonQo.getSort());
//
//        return new PageInfo<>(materialService.list(entity,commonQo));
//    }
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "expiration_date desc");
        //  通过服务层获取查询后的用户列表
        List<Material> materialList = materialService.listAll(entity, commonQo);
        //  返回 pageBean实体
        return new PageInfo<Material>(materialList);
    }
    // 接受一个新Excel

    /**
     * 导入用excel
     *
     * @param request   请求域
     * @param excelFile excel文件，前端用multipart/form-data类型上传
     * @return Message
     */
    @ResponseBody
    @RequestMapping("excel/pull")

    public Message pullMaterialExcel(HttpServletRequest request, MultipartFile excelFile) {
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
                System.out.println("================" + newFile.toString());

                MaterialUtilExcel materialUtilExcel = new MaterialUtilExcel(newFile.toString());
                //userExcelUtil.setEntityMap();
                Map<Integer, MaterialExcel> materialExcelMap = materialUtilExcel.getMap();
                if (materialExcelMap == null)
                    return new Message("2", "物资导入失败，请检查excel表与模板的不同");
                //  java8 lambda遍历
                materialExcelMap.forEach((key, value) -> {
                    //  复制UserExcel对象到user类中
                    Material material = new Material();
                    BeanUtils.copyProperties(value, material);
                    material.setIdStorage(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                    try {
                        materialService.add(material);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                return new Message("1", "物资导入成功");
            } else {
                return new Message("2", "上传失败或者上传的文件后缀不是'xls'或'xlsx'");
            }
        } catch (Exception e) {
            //return new Message("2","名单导入失败，请检查excel表与模板的不同");
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("excel/push")
    public ResponseEntity<byte[]> pushExcel(Material material) throws Exception {
        ExportExcelUtil<Material> exportExcelUtil = new ExportExcelUtil<>();

        List<Material> materialList = materialService.findList(material);
        String[] headers = {"物资编号", "进厂时间", "物资名称", "物资有效期", "关联厂商", "联系电话", "是否过期", "物资数量", "计数单位", "存储地点", "存储方式", "备注", "记录者编号", "登录者编号"};
        //  通过标题和数据库数据生成XLS文件
        //Workbook wb = exportExcelUtil.exportXLS("用户表单",headers,userList);
        // 直接调用工具类生成xls或xlsx文件,用户访问此链接直接下载
        return exportExcelUtil.exportXLSXOutput("物资列表", headers, materialList);
    }



}
