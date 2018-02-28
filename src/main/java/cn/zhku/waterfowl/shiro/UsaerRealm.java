package cn.zhku.waterfowl.shiro;

import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.pojo.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/19 23:13.
 * 说明：
 */
public class UsaerRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(UsaerRealm.class);

    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
    @Autowired
    private ShiroDao shiroDao;

    @Autowired
    private UserMapper userMapper;



    /**
     * 提供用户信息返回权限信息
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<String> roleIdSet = shiroDao.findRoleByUserId(userId);
        logger.info("============ roleSet ============="+roleIdSet.toString());
        System.out.println();
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleIdSet);

        // 根据用户名查询当前用户权限
        Set<String> permissionSet = shiroDao.findPermissionByUserId(userId);
        logger.info("===========  permissionSet =============="+permissionSet.toString());
        System.out.println();
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     * @param token the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                 realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userId = (String) token.getPrincipal();
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getId(),
                user.getPassword(), getName());
        return authenticationInfo;
    }
}
