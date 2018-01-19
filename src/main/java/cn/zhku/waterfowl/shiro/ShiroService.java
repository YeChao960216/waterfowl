package cn.zhku.waterfowl.shiro;

import cn.zhku.waterfowl.pojo.entity.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/19 23:15.
 * 说明：这是shiro获取用户注册信息和角色权限信息的服务中心
 */

@Service
public class ShiroService {


    /**
     *  查找登录管理员的角色
     * @param adminId   管理员id
     *  @return 角色集合
     */
    public Set<String> findRoleIds(String adminId) {
        return null;
    }

    /**
     *  查找登录管理员的所有权限
     * @param roleIds   管理员的角色集合
     * @return  权限集合
     */
    public Set<String> findAuthorities(Set<String> roleIds) {
        return null;
    }


    /**
     *  通过管理呀员查找管理员
     * @param adminId   管理员id
     * @return User
     */
    public User findByUserId(String adminId){
        return null;
    }


}
