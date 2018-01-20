package com.zhku.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class testData {

    @ResponseBody
    @RequestMapping(value = "/data")
    public String returnData(){
        return "[1,2,3,4,5,6]";
    }
}
