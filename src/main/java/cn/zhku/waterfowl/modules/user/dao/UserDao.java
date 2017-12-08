package cn.zhku.waterfowl.modules.user.dao;

import cn.zhku.waterfowl.pojo.entity.Role;
import cn.zhku.waterfowl.pojo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/10/25 21:32.
 * 说明：User模块专有的dao接口
 *  你们最喜欢的直接写sql语句。
 */
public interface UserDao {

    /**
     *  查找用户拥有的权限
     * @param id  user表用户的id
     * @return
     */
    @Select("select * from role where id in (select role_id from user_role where user_id = #{id})")
    List<Role> findRolesById (String id) ;

    /**
     *  通过手机号查找用户
     * @param phone 手机号
     * @return  User
     */
    @Select("select * from user where phone = #{phone}")
    User findUserByPhone(String phone);
}
