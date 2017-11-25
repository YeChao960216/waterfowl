package cn.zhku.waterfowl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class test {

    @ResponseBody
    @RequestMapping(value = "/data")
    public String returnData(){
        return "{id:11111}";
    }
    @RequestMapping(value = "/daa")
    public String view(){
        System.out.println("================================");
        return "/aquacultureManagePage/delete";
    }
}