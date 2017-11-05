package cn.zhku.waterfowl.modules.aquaculture.controller;


import cn.zhku.waterfowl.modules.aquaculture.service.AquacultureService;
import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.util.modle.CommonQo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/aquaculture")
public class AquacultureController{
    @Autowired
    AquacultureService aquacultureService;

    /**
     * 增加记录
     * @param aquaculture
     * @return Aquaculture
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("new")
    public int addAquaculture(Aquaculture aquaculture) throws Exception {
        aquaculture.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置记录id
        return aquacultureService.add(aquaculture);
    }

    /**
     * 删除记录
     * @param id
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("delete/{id}")
    public int deleteAquaculture(@PathVariable String id) throws Exception {
        Aquaculture aquaculture = new Aquaculture();
        aquaculture.setId(id);
        return aquacultureService.delete(aquaculture);
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
    public int editAquaculture(@PathVariable String id,Aquaculture aquaculture) throws Exception {
        aquaculture.setId(id);
        return aquacultureService.update(aquaculture);
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

    //展示所有记录
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<Aquaculture> listUser(Aquaculture aquaculture, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<Aquaculture> aquacultureList =  aquacultureService.findList(aquaculture);
        //  返回 pageBean
        return new PageInfo<Aquaculture>(aquacultureList);
    }
}
