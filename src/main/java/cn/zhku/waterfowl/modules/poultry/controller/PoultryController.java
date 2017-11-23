package cn.zhku.waterfowl.modules.poultry.controller;

import cn.zhku.waterfowl.modules.poultry.service.PoultryService;
import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
         * @return Message
         * @throws Exception sql、bean检验
         */
        @ResponseBody
        @RequestMapping("add")
        public Message addPoultry(Poultry poultry) throws Exception {
            poultry.setIdPoultry(UUID.randomUUID().toString().replace("-", "").toUpperCase());   //用32位长度的UUID来设置用户id
            if (poultryService.add(poultry) == 1)
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
        public Message delete(@PathVariable String id, Poultry entity) throws Exception {
            entity.setIdPoultry(id);
            if (poultryService.delete(entity) == 1)
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
        public Message update(@PathVariable String id, Poultry entity) throws Exception {
            entity.setIdPoultry(id);
            if (poultryService.update(entity) == 1)
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
        public Poultry get(@PathVariable String id) throws Exception {
            return poultryService.get(id);
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
         * @param poultry  poultry实体的各个字段
         * @param commonQo 通用查询类，拥有pageSize,
         * @return PageInfo<OutStorage> 一个带有List<OutStorage>的pageBean
         * @throws Exception sql
         */
        @ResponseBody
        @RequestMapping("selectBy")
        public PageInfo<Poultry> select(Poultry poultry, CommonQo commonQo) throws Exception {
            //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
            PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "record_date desc");
            //  通过服务层获取查询后的用户列表
            List<Poultry> poultryList = poultryService.findList(poultry);
            //  返回 pageBean实体
            return new PageInfo<Poultry>(poultryList);
        }
        //分页展示出库记录

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
    }
