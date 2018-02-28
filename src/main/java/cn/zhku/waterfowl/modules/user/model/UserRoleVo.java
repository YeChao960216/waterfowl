package cn.zhku.waterfowl.modules.user.model;

import cn.zhku.waterfowl.pojo.entity.Role;
import cn.zhku.waterfowl.pojo.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/9 22:09.
 * 说明：用户信息和角色信息
 */
public class UserRoleVo {
   private User user;

   private List<Role> roleList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserRoleVo{" +
                "user=" + user +
                ", roleList=" + roleList +
                '}';
    }
}
