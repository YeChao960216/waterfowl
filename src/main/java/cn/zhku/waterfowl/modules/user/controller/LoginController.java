package cn.zhku.waterfowl.modules.user.controller;

import cn.zhku.waterfowl.modules.user.service.LoginService;
import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.util.modle.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

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
     * @param form  User类，必须参数：phone，password
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public Message login(User form, HttpSession httpSession){
        User user = loginService.login(form);
        if(user != null){
            httpSession.setAttribute("user",user);
            return new Message("1","用户登录成功");
        }
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
        user.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位长度的UUID来设置用户id
        user.setDuty("职务");
        user.setGender((byte) 3);
        user.setName("真实姓名");
        user.setRemark("备注");
        user.setRoleId("404");
        user.setSign("3");
        user.setTurnover(new Date());
        if(loginService.register(user) == 1)
            return new Message("1","用户注册成功");
        else
            return new Message("2","用户注册失败");
    }


    /**
     *  验证用户名是否被注册
     * @param username  用户名
     * @return Message
     */
    @ResponseBody
    @RequestMapping("/user/registerCheckUsername")
    public Message registerVerifyCode(String username){
        if(loginService.registerCheckUsername(username))
            return new Message("1","用户名尚未被注册");
        else
            return new Message("2","用户名已经被注册");

    }

    @RequestMapping("/user/nowUserInfo")
    @ResponseBody
    public User nowUserInfo(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        user.setPassword("  ");
        return user;
    }
}
