package cn.zhku.waterfowl.modules.user.controller;

import cn.zhku.waterfowl.util.modle.Message;
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

    @ResponseBody
    @RequestMapping("/login")
    public Message login(){
        return new Message("1","登录成功");
    }
}
