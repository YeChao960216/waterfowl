package cn.zhku.waterfowl.modules.dictionary.controller;

import cn.zhku.waterfowl.modules.dictionary.service.DictionaryService;
import cn.zhku.waterfowl.pojo.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/13 23:06.
 * 说明：
 */
@RestController
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/dict/list")
    public List<Dictionary> list() throws Exception {
        return dictionaryService.findList(null);
    }
}
