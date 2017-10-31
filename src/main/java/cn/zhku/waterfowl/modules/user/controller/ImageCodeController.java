package cn.zhku.waterfowl.modules.user.controller;

import cn.zhku.waterfowl.util.imageCode.ImageCode;
import cn.zhku.waterfowl.util.modle.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/10/28 21:58.
 * 说明：处理验证码的Controller
 */

@Controller
public class ImageCodeController {

    @RequestMapping(value = "/images/imagecode")
    public String imagecode(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        OutputStream os = response.getOutputStream();
        Map<String,Object> map = ImageCode.getImageCode(60, 20, os);    //  返回一个存放验证码数值和图片的map

        String simpleCaptcha = "simpleCaptcha";
        request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());    //  预设存放验证码数值的session
        request.getSession().setAttribute("codeTime",new Date().getTime()); //  验证码放入session的时间

        try {
            ImageIO.write((BufferedImage) map.get("image"), "JPEG", os);
        } catch (IOException e) {
            return "";
        }
        return null;
    }

    @RequestMapping(value = "/images/checkcode")
    @ResponseBody
    public Message checkcode(HttpServletRequest request, HttpSession session)
            throws Exception {
        String checkCode = request.getParameter("checkCode");
        Object cko = session.getAttribute("simpleCaptcha") ; //验证码对象
        if(cko == null){
            request.setAttribute("errorMsg", "验证码已失效，请重新输入！");
            return new Message("2","验证码已失效，请重新输入！");
        }

        String captcha = cko.toString();
        Date now = new Date();
        Long codeTime = Long.valueOf(session.getAttribute("codeTime")+"");
        if(StringUtils.isEmpty(checkCode) || captcha == null ||  !(checkCode.equalsIgnoreCase(captcha))){
            //request.setAttribute("errorMsg", "验证码错误！");
            return new Message("2","验证码错误！");
        }else if ((now.getTime()-codeTime)/1000/60>5){//验证码有效时长为5分钟
            //request.setAttribute("errorMsg", "验证码已失效，请重新输入！");
            return new Message("2","验证码已失效，请重新输入！");
        }else {
            session.removeAttribute("simpleCaptcha");
            return new Message("1","输入验证码成功");
        }
    }
}
