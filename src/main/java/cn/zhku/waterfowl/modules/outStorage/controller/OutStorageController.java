package cn.zhku.waterfowl.modules.outStorage.controller;

/**
 * @author  : 叶超
 *  date    : 2017-11-9
 *  E-mail  : yc755909707@foxmail.com
 */

import cn.zhku.waterfowl.modules.outStorage.model.OutStorageExcel;
import cn.zhku.waterfowl.modules.outStorage.model.OutStorageUtilExcel;
import cn.zhku.waterfowl.modules.outStorage.service.OutStorageService;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.util.SessionUtil;
import cn.zhku.waterfowl.util.excel.ExportExcelUtil;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 对出库outstorage状态操作的controller,继承BaseController以便使用全局变量和参数绑定
 */
@Controller
@RequestMapping("/outstorage/")
public class OutStorageController extends BaseController{
        @Autowired
        OutStorageService outStorageService;

        /** 增加出库记录
         * 测试完成
         * @param  outstorage 实体类的各种字段，如
         * @return storage
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("add")
        public Message addOutstorage(Outstorage outstorage) throws Exception {
            //  从shrio Session中获取user的session,填充记录员的字段
            outstorage.setIdRecorder(SessionUtil.getUserSession().getId());
            outstorage.setIdOutstorage(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
            Timestamp t = new Timestamp(System.currentTimeMillis());
            outstorage.setRecordDate(t);
            outstorage.setRest(outstorage.getQuantity());
            if (outstorage.getValid()==null||outstorage.getValid().isEmpty()){
                outstorage.setValid("未过期");
            }
             if (outStorageService.add(outstorage)==1){
                return new Message("1","添加物资记录成功");
            }
            else{
                 return new Message("2","添加物资记录失败");
             }

        }

        /** 根据记录表id删除对象
         * 测试完成
         * @param idOutStorage 只需id字段
         * @return message
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("delete/{idOutStorage}")
        public Message deleteOutstorage(@PathVariable String idOutStorage) throws Exception {
            Outstorage outstorage =  new Outstorage();
            outstorage.setIdOutstorage(idOutStorage);
            if(outStorageService.delete(outstorage) == 1)
                return new Message("1","删除物资记录成功");
            else
                return new Message("2","删除物资记录失败");
        }
        /** 根据id修改出库记录
         *  测试成功
         * @param   id,Storage 不包括记录表的各个Outstorage实体类字段
         * @return  message
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("edit/{id}")
        public Message editOutstorage(@PathVariable String id, Outstorage outstorage) throws Exception {
            outstorage.setIdOutstorage(id);
            if(outStorageService.update(outstorage) == 1)
                return new Message("1","修改物资记录成功");
            else
                return new Message("2","修改物资记录失败");
        }
        /**
         *  根据多个条件展示一列用户 => 多条件查询分页
         * @param outstorage outstorage实体的各个字段
         * @param commonQo   通用查询类，拥有pageSize,
         * @return  PageInfo<OutStorage> 一个带有List<OutStorage>的pageBean
         * @throws Exception    sql
         */
        @ResponseBody
        @RequestMapping("list")
        public PageInfo<Outstorage> select(Outstorage outstorage, CommonQo commonQo) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            if (commonQo.getSort().equals("1"))  //字符串"1"是sort的默认值，相当于 order by 1 ,即按主键排序
            {
                commonQo.setSort("expiration_date");
            }
            else if(commonQo.getSort().equals("2")){
                commonQo.setSort("record_date");
            }
            else{
                commonQo.setSort("record_date desc");
            }
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(),commonQo.getSort());
            //  通过服务层获取查询后的用户列表
            List<Outstorage> outstorageList =  outStorageService.findList(outstorage);
            //  返回 pageBean实体
            return new PageInfo<Outstorage>(outstorageList);
        }
        /**
         *  根据多个条件展示一列用户 => 多条件查询分页
         * @return  PageInfo<Outstorage> 一个带有List<Outstorage>的pageBean
         * @throws Exception    sql
         */


    @ResponseBody
    @RequestMapping("listName/{type}")
    public List<Outstorage> Listname(@PathVariable String type) throws Exception {
        //  通过服务层获取查询后的用户列表
        //将返回的值放在ArrayList里面，以Outstorage模板呈现，没有的字段为null
        List<Outstorage> outStorageList =  new ArrayList<Outstorage> (outStorageService.Listname(type));
        //  返回 pageBean实体
        return outStorageList;
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

    public Message pullPoultryExcel(HttpServletRequest request, MultipartFile excelFile) {
        try {
            if (excelFile != null || excelFile.getOriginalFilename().endsWith("xls") || excelFile.getOriginalFilename().endsWith("xlsx")) {
                //List<MaterialModel> models=userService.insertUserByExcel(excelFile);
                //  储存图片的物理路径
                String realPath = request.getServletContext().getRealPath("/WEB-INF/excel/outStorage/");
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

                OutStorageUtilExcel outStorageUtilExcel = new OutStorageUtilExcel(newFile.toString());
                //userExcelUtil.setEntityMap();
                Map<Integer,OutStorageExcel> outStorageExcelMap = outStorageUtilExcel.getMap();
                if (outStorageExcelMap == null)
                    return new Message("2", "物资信息导入失败，请检查excel表与模板的不同");
                //  java8 lambda遍历
                outStorageExcelMap.forEach((key, value) -> {
                    //  复制UserExcel对象到user类中
                    Outstorage outstorage= new Outstorage();
                    BeanUtils.copyProperties(value, outstorage);
                    outstorage.setIdOutstorage(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                    try {
                        outStorageService.add(outstorage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                return new Message("1", "物资导入成功");
            } else {
                return new Message("2", "上传失败或者上传的文件后缀不是'xls'或'xlsx'");
            }
        } catch (Exception e) {
            //return new Msg("2","名单导入失败，请检查excel表与模板的不同");
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("excel/push")
        public ResponseEntity<byte[]> pushExcel(Outstorage outstorage) throws Exception {
        ExportExcelUtil<Outstorage> exportExcelUtil = new ExportExcelUtil<>();
        List<Outstorage> outstorageList = outStorageService.findList(outstorage);
        String[] headers = {"物资编号", "供应商", "记录时间", "数量", "单位", "生产厂家", "物资类型", "有效期", "剩余量","有效期","联系电话","是否有效","备注1","备注2", "备注3","录入人","负责人"};
        //  通过标题和数据库数据生成XLS文件
        //Workbook wb = exportExcelUtil.exportXLS("用户表单",headers,userList);
        // 直接调用工具类生成xls或xlsx文件,用户访问此链接直接下载
        return exportExcelUtil.exportXLSXOutput("物资表", headers, outstorageList);
    }
}

