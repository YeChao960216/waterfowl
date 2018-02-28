package cn.zhku.waterfowl.modules.poultry.controller;


import cn.zhku.waterfowl.modules.poultry.model.PoultryExcel;
import cn.zhku.waterfowl.modules.poultry.model.PoultryUtilExcel;
import cn.zhku.waterfowl.modules.poultry.service.PoultryService;
import cn.zhku.waterfowl.pojo.entity.Poultry;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/poultry/")
public class PoultryController extends BaseController {
        @Autowired
        PoultryService poultryService;

        /**
         * 增加一条数据
         *
         * @param poultry 实体类
         * @return Msg
         * @throws Exception sql、bean检验
         */
        @ResponseBody
        @RequestMapping("add")
        public Message addPoultry(Poultry poultry) throws Exception {
            //  从shrio Session中获取user的session,填充记录员的字段
            poultry.setIdRecorder(SessionUtil.getUserSession().getId());
            poultry.setIdPoultry(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位长度的UUID来设置用户id
            Timestamp t = new Timestamp(System.currentTimeMillis());
            poultry.setRecordDate(t);
            if (poultryService.add(poultry) == 1)
                return new Message("1", "插入材料成功");
            else
                return new Message("2", "插入材料失败");

        }

        /**
         * 删除一条记录
         *
         * @param entity id 表主键
         * @return Msg
         * 1     * @throws Exception   sql、bean检验
         */

        @ResponseBody
        @RequestMapping("delete/{id}")
        public Message delete(@PathVariable String id, Poultry entity) throws Exception {
            entity.setIdPoultry(id);
            if (poultryService.delete(entity) == 1)
                return new Message("1", "成功删除材料");
            else
                return new Message("2", "删除材料失败");
        }

        /**
         * @param entity 实体类
         * @return Msg
         * @throws Exception sql、bean检验
         */

        @ResponseBody
        @RequestMapping("edit/{id}")
        public Message update(@PathVariable String id, Poultry entity) throws Exception {
            entity.setIdPoultry(id);
            if (poultryService.update(entity) == 1)
                return new Message("1", "更新材料信息成功");
            else
                return new Message("2", "更新材料信息失败");
        }

//        /**
//         * 获取一条记录
//         *
//         * @param id 表主键
//         * @return Msg
//         * @throws Exception sql、bean检验
//         */
//        @ResponseBody
//        @RequestMapping("select/{id}")
//        public Poultry get(@PathVariable String id) throws Exception {
//            return poultryService.get(id);
//        }

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
         * @param poultry  poultry实体的各个字段
         * @param commonQo 通用查询类，拥有pageSize,
         * @return PageInfo<OutStorage> 一个带有List<OutStorage>的pageBean
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("list")
        public PageInfo<Poultry> select(Poultry poultry, CommonQo commonQo) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "record_date desc");
            //  通过服务层获取查询后的用户列表
            List<Poultry> poultryList = poultryService.findList(poultry);
            //  返回 pageBean实体
            return new PageInfo<Poultry>(poultryList);
        }
        //分页展示出库记录\
        @ResponseBody
        @RequestMapping("selectBy/{id}")
        public Poultry select(@PathVariable String id) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            return poultryService.get(id);
            //  返回 pageBean实体
//            return new PageInfo<Poultry>(poultryList);
        }

        @ResponseBody
        @RequestMapping("show")
        public PageInfo<Poultry> show(Poultry entity, CommonQo commonQo) throws Exception {
//        //  设置默认的排序，如果前端需要排训查询，则加上参数  sort = 数据库字段 ，
//        if (commonQo.getSort().equals("1"))  //字符串"1"是sort的默认值，相当于 order by 1 ,即按主键排序
//        commonQo.setSort("date desc");
//        PageHelper.startPage(commonQo.getPageNum(),commonQo.getPageSize(),commonQo.getSort());
//
//        return new PageInfo<>(poultryService.list(entity,commonQo));
//    }
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "record_date desc");
            //  通过服务层获取查询后的用户列表
            List<Poultry> poultryList = poultryService.showAll(entity, commonQo);
            //  返回 pageBean实体
            return new PageInfo<Poultry>(poultryList);
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
                String realPath = request.getServletContext().getRealPath("/WEB-INF/excel/poultry/");
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

                PoultryUtilExcel poultryUtilExcel = new PoultryUtilExcel(newFile.toString());
                //userExcelUtil.setEntityMap();
                Map<Integer,PoultryExcel> poultryExcelMap = poultryUtilExcel.getMap();
                if (poultryExcelMap == null)
                    return new Message("2", "物资导入失败，请检查excel表与模板的不同");
                //  java8 lambda遍历
                poultryExcelMap.forEach((key, value) -> {
                    //  复制UserExcel对象到user类中
                    Poultry poultry= new Poultry();
                    BeanUtils.copyProperties(value, poultry);
                    poultry.setIdPoultry(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                    try {
                        poultryService.add(poultry);
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
    public ResponseEntity<byte[]> pushExcel(Poultry poultry) throws Exception {
        ExportExcelUtil<Poultry> exportExcelUtil = new ExportExcelUtil<>();

        List<Poultry> poultryList = poultryService.findList(poultry);
        String[] headers = {"入库编号", "记录时间", "家禽类型", "数量", "单位", "关联厂商", "联系电话", "备注", "登录者编号", "负责人编号"};
        //  通过标题和数据库数据生成XLS文件
        //Workbook wb = exportExcelUtil.exportXLS("用户表单",headers,userList);
        // 直接调用工具类生成xls或xlsx文件,用户访问此链接直接下载
        return exportExcelUtil.exportXLSXOutput("禽类入库表", headers, poultryList);
    }

}
