package cn.zhku.waterfowl.modules.user.controller;

import cn.zhku.waterfowl.modules.user.service.LoginService;
import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.util.modle.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/10/23 21:49.
 * 说明：登录注册 Controller
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     *  用户登录
     * @param user  User类，必须参数：phone，password
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public Message login(User user){
        if(loginService.login(user))
            return new Message("1","用户登录成功");
        else
            return new Message("2","用户登录失败");
    }

    @ResponseBody
    @RequestMapping("/user/CheckPhone")
    public Message loginCheckPhone(User user){
        if(loginService.CheckPhone(user))
            return new Message("1","手机号未注册");
        else
            return new Message("2","手机号已注册");
    }



    @ResponseBody
    @RequestMapping("/user/register")
    public Message loginCheckPhone(User user,String verifyCode){
        if(loginService.register(user))
            return new Message("1","用户注册成功");
        else
            return new Message("2","用户注册失败");
    }


    //  注册验证码
    @ResponseBody
    @RequestMapping("/user/registerVerifyCode")
    public Message registerVerifyCode(){
        return null;
    }




}
