package cn.zhku.waterfowl.modules.user.service;

import cn.zhku.waterfowl.modules.user.dao.UserDao;
import cn.zhku.waterfowl.modules.user.model.UserRoleVo;
import cn.zhku.waterfowl.pojo.entity.Role;
import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/9 22:11.
 * 说明：
 */

@Service
public class RoleService implements IBaseService<Role> {


    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;


    /**
     *  查找用户信息和用户权限列表
     * @param id    用户id
     * @return  视图
     * @throws Exception    sql
     */
    public UserRoleVo getRoleList(String id) throws Exception {
        UserRoleVo userRoleVo = new UserRoleVo();
        User user = userService.get(id);
        List<Role> roleList = userDao.findRolesById(id);
        userRoleVo.setUser(user);
        userRoleVo.setRoleList(roleList);
        return userRoleVo;
    }




    @Override
    public int add(Role entity) throws Exception {
        return 0;
    }

    @Override
    public int update(Role entity) throws Exception {
        return 0;
    }

    @Override
    public int delete(Role entity) throws Exception {
        return 0;
    }

    @Override
    public Role get(String id) throws Exception {
        return null;
    }

    @Override
    public Role get(Role entity) throws Exception {
        return null;
    }

    @Override
    public List<Role> findList(Role entity) throws Exception {
        return null;
    }
}
