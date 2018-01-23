package cn.zhku.waterfowl.util;

import cn.zhku.waterfowl.pojo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/22 19:59.
 * 说明：有关会话Session的工具类
 */
public final class  SessionUtil {



    public static User getUserSession() throws InvalidSessionException {
        Session session = SecurityUtils.getSubject().getSession();
        return (User) session.getAttribute("user");
    }
}
