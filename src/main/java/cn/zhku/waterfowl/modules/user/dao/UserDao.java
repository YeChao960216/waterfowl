package cn.zhku.waterfowl.modules.user.dao;

import cn.zhku.waterfowl.pojo.entity.Role;
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
    @Select("select * from user_role where user_id = (select id from user where id = #{id})")
    List<Role> findRoleById (String id) ;
}
