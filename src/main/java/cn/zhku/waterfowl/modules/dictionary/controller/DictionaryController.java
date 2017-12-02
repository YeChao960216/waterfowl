package cn.zhku.waterfowl.modules.dictionary.controller;

import cn.zhku.waterfowl.modules.dictionary.service.DictionaryService;
import cn.zhku.waterfowl.pojo.entity.Dictionary;
import cn.zhku.waterfowl.util.modle.Message;
import org.dozer.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     *  多条件查找字典
     * @param dict 参数 :pid 字典父节点, name 字典名字
     * @return  字典数组
     * @throws Exception    sql
     */
    @RequestMapping("/dict/list")
    public List<Dictionary> list(Dictionary dict) throws Exception {
        return dictionaryService.findList(dict);
    }

    /**
     *  查找单个字典
     * @param id    字典主键
     * @return  message
     * @throws Exception    sql
     */
    @RequestMapping("/dict/show/{id}")
    public Dictionary show(@PathVariable String id) throws Exception {
        return dictionaryService.get(id);
    }

    /**
     *   删除字典
     * @param id    主键id
     * @param dictionary   无需
     * @return
     * @throws Exception
     */
    @RequestMapping("/admin/delete/{id}")
    public Message delete(@PathVariable String id, Dictionary dictionary) throws Exception {
        dictionary.setId(id);
        if (dictionaryService.delete(dictionary) == 1)
            return new Message("1","删除字典成功");
        else
            return new Message("2","删除字典失败");
    }

    /**
     *  修改字典
     * @param id    主键
     * @param dictionary    name,pid
     * @return message
     * @throws Exception sql
     */
    @RequestMapping("/admin/edit/{id}")
    public Message edit(@PathVariable String id, Dictionary dictionary) throws Exception {
        dictionary.setId(id);
        if (dictionaryService.update(dictionary) == 1)
            return new Message("1","更新字典成功");
        else
            return new Message("2","更新字典失败");
    }

    /**
     *  增加字典,不能增加名字相同或主键id相同的字典
     * @param dictionary    字典的所有属性
     * @return  message
     * @throws Exception    sql
     */
    @RequestMapping("/admin/new")
    public Message add(Dictionary dictionary) throws Exception {
        if (dictionaryService.update(dictionary) == 1)
            return new Message("1","增加字典成功");
        else
            return new Message("2","增加字典失败,请检查主键或名字是否重复");
    }






}
