package cn.zhku.waterfowl.modules.user.controller;

import cn.zhku.waterfowl.modules.user.model.UserRoleVo;
import cn.zhku.waterfowl.modules.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/9 22:10.
 * 说明：
 */
@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     *  查找用户信息和权限
     * @param id    用户id
     * @return  视图
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("/admin/user/empInfo/{id}")
    public UserRoleVo empInfo(@PathVariable String id) throws Exception {
        return roleService.getRoleList(id);
    }
}
