//package cn.zhku.waterfowl.modules.epidemic.controller;
//import cn.zhku.waterfowl.modules.epidemic.service.EpidemicService;
//import cn.zhku.waterfowl.pojo.entity.Epidemic;
//import cn.zhku.waterfowl.util.modle.CommonQo;
//import cn.zhku.waterfowl.util.modle.Message;
//import cn.zhku.waterfowl.web.BaseController;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.stereotype.Controller;
//import java.util.List;
//import java.util.UUID;
///**
// * @author  : 林伟佳
// *  date    : 2017-10-26
// *  E-mail  : 984613906@qq.com
// */
//    /**
//     * 对免疫epidemic状态操作的controller,继承BaseController以便使用全局变量和参数绑定
//     */
//    @Controller
//    @RequestMapping("/epidemic/")
//    public class EpidemicController extends BaseController {
//        @Autowired
//        EpidemicService epidemicService;
//
//        /** 增加免疫记录
//         * 测试完成
//         * @param  epidemic 实体类的各种字段，如
//         * @return epidemic
//         * @throws Exception sql
//         */
//        @ResponseBody
//        @RequestMapping("save")
//        public Message addEpidemic(Epidemic epidemic) throws Exception {
//
//            epidemic.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
//            epidemic.setFlag(0);
//            if(epidemicService.add(epidemic) == 1)
//                return new Message("1","添加疾病/免疫记录表成功");
//            else
//                return new Message("2","添加疾病/免疫记录表失败");
//        }
//
//        /** 根据记录表id删除对象
//         * 测试完成
//         * @param id 只需id字段
//         * @return message
//         * @throws Exception sql
//         */
//        @ResponseBody
//        @RequestMapping("delete/{id}")
//        public Message deleteEpidemic(@PathVariable String id) throws Exception {
//            Epidemic epidemic =  new Epidemic();
//            epidemic.setId(id);
//            if(epidemicService.delete(epidemic) == 1)
//                return new Message("1","删除疾病/免疫记录表成功");
//            else
//                return new Message("2","删除疾病/免疫记录表失败,已经提交的数据无法删除");
//        }
//        /** 根据id修改免疫记录
//         *  测试成功
//         * @param   id 不包括记录表的各个Epidemic实体类字段
//         * @return  message
//         * @throws Exception    sql
//         */
//        @ResponseBody
//        @RequestMapping("edit/{id}")
//        public Message editEpidemic(@PathVariable String id, Epidemic epidemic) throws Exception {
//            epidemic.setId(id);
//            if(epidemicService.update(epidemic) == 1)
//                return new Message("1","修改疾病/免疫记录表成功");
//            else
//                return new Message("2","修改疾病/免疫记录表成失败");
//        }
//        /**
//        * 根据多个id更改提交状态为已提交
//        * @param idList
//         * @return Message
//         * @throws Exception sql
//        * */
//        @ResponseBody
//        @RequestMapping("editFlagById")
//        public Message editFlagById(String []idList){
//                if (epidemicService.updateFlag(idList)==1)
//                    return new Message("1","提交疾病/免疫记录表成功");
//                else
//                    return new Message("2","提交疾病/免疫记录表成失败");
//        }
//        @ResponseBody
//        @RequestMapping("editFlagById/{id}")
//        public Message editFlagById(@PathVariable String id) throws Exception {
//
//            if (epidemicService.updateFlag(id)==1)
//                return new Message("1","提交疾病/免疫记录表成功");
//            else
//                return new Message("2","提交疾病/免疫记录表成失败");
//        }
//        /** 根据id修改免疫记录
//         *  测试成功
//         * @param   epidemic 包括记录表id的各个Epidemic实体类字段
//         * @return  message
//         * @throws Exception    sql
//         */
//        @ResponseBody
//        @RequestMapping("edit")
//        public Message editEpidemic(Epidemic epidemic) throws Exception {
//
//            if(epidemicService.update(epidemic) == 1)
//                return new Message("1","修改疾病/免疫记录表成功");
//            else
//                return new Message("2","修改疾病/免疫记录表成失败");
//        }
//
//        /** 根据id展示免疫信息
//         * 测试完成
//         * @param id   只需记录表id
//         * @return Epidemic实体
//         * @throws Exception    sql
//         */
//        @ResponseBody
//        @RequestMapping("show/{id}")
//        public Epidemic showById(@PathVariable String id) throws Exception {
//            return epidemicService.get(id);
//        }
//        /*根据flag分页展示数据
//         *  测试完成
//         *   其中flag=0 表示未提交   flag=1表示已提交
//         *@param epidemic  flag
//         * @param commonQo   查询类，拥有pageSize,
//         * @return  PageInfo<Epidemic> 一个带有List<User>的pageBean
//         * @throws Exception    sql
//         * */
//        @ResponseBody
//        @RequestMapping("showByFlag/{flag}")
//        public PageInfo<Epidemic> showByFlag(@PathVariable int flag,CommonQo commonQo){
//            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
//            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
//            //  通过服务层获取查询后的用户列表
//            List<Epidemic> epidemicList =  epidemicService.showAllByFlag(flag);
//            //  返回 pageBean
//            return new PageInfo<Epidemic>(epidemicList);
//        }
//
//        //分页展示免疫记录表
//        /**
//         *  根据多个条件展示一列用户 => 多条件查询分页
//         * @param epidemic   epidemic实体的各个字段
//         * @param commonQo   通用查询类，拥有pageSize,
//         * @return  PageInfo<Epidemic> 一个带有List<Epidemic>的pageBean
//         * @throws Exception    sql
//         */
//        @ResponseBody
//        @RequestMapping("findList")
//        public PageInfo<Epidemic> findList(Epidemic epidemic, CommonQo commonQo) throws Exception {
//            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
//            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
//            //  通过服务层获取查询后的用户列表
//            List<Epidemic> epidemicList =  epidemicService.findList(epidemic);
//
//            //  返回 pageBean实体
//            return new PageInfo<Epidemic>(epidemicList);
//        }
//
//    }
//
