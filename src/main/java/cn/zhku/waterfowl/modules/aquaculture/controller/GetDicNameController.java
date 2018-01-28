package cn.zhku.waterfowl.modules.aquaculture.controller;

import cn.zhku.waterfowl.modules.aquaculture.service.GetDicNameService;
import cn.zhku.waterfowl.pojo.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 成君
 * @date 2017/11/21 0021 21:32
 * @E-mail 943193747@qq.com
 */
@Controller
@RequestMapping("/getDicName")
public class GetDicNameController {
    @Autowired
    GetDicNameService getDicNameService;

    /**
     * 去dictionary拿家禽养殖阶段status的值
     * @return
     */
    @ResponseBody
    @RequestMapping("getStatus")
    public List<Dictionary> getStatusFromAquaculture(){
        return setPid("30000");
    }

    /**
     * 去dictionary拿家禽养殖类型type的值
     * @return
     */
    @ResponseBody
    @RequestMapping("getBreedingType")
    public List<Dictionary> getBreedingTypeFromAquaculture(){
        return setPid("60000");
    }

    /**
     * 设置pid
     * @return
     */
    public List<Dictionary> setPid(String pid){
        return getDicNameService.getNameFromDictionary(pid);
    }
}