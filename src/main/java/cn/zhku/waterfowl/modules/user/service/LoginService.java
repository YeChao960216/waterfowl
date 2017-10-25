package cn.zhku.waterfowl.modules.user.service;

import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.pojo.entity.UserExample;
import cn.zhku.waterfowl.pojo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/10/23 21:50.
 * 说明：登录注册服务
 */
@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;


    /**
     *  登录服务
     * @param form  user ,必须参数:phone，password
     * @return True：成功 False：失败
     */
    public boolean login(User form) {
        UserExample userExample = new UserExample();
        userExample.or().andPhoneEqualTo(form.getPhone());
        User user = userMapper.selectByExample(userExample).get(0);
        if (user.getPassword().equals(form.getPassword()))
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    //检验手机号
    public boolean CheckPhone(User user) {
        return false;
    }


    public boolean register(User user) {
        return false;
    }
}
