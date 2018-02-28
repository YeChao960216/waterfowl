package cn.zhku.waterfowl.modules.dictionary.controller;

import cn.zhku.waterfowl.modules.dictionary.service.DictionaryService;
import cn.zhku.waterfowl.pojo.entity.Dictionary;

import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public PageInfo<Dictionary> list(Dictionary dict, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(),commonQo.getSort());
        return new PageInfo<Dictionary>(dictionaryService.findList(dict));
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
        if(Integer.parseInt(dictionaryService.get(id).getPid())==0){
//            if (id.equals(10000)||id.equals(11000)||id.equals(12000)||id.equals(11000)){}
        dictionaryService.delete(dictionary);
        dictionaryService.deleteAll(id);
            return new Message("1","删除字典栏目成功");
        }
        else if(dictionaryService.delete(dictionary)==1){
            return new Message("2","删除字典信息成功");
        }
        else{
            return new Message("3","删除字典信息失败");
        }
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
        dictionary.setId(dictionaryService.raise(dictionary.getPid()));
        if (dictionaryService.add(dictionary) == 1)
            return new Message("1","增加字典信息成功");
        else
            return new Message("2","增加字典信息失败");
    }


    /**
     *  增加字典,不能增加名字相同或主键id相同的字典
     * @param dictionary    字典的所有属性
     * @return  message
     * @throws Exception    sql
     */
    @RequestMapping("/admin/insert")
    public Message insert(Dictionary dictionary) throws Exception {
        dictionary.setId(dictionaryService.insert());
        dictionary.setPid(String.valueOf(0));
        if (dictionaryService.add(dictionary) == 1)
            return new Message("1","增加字典栏目成功");
        else
            return new Message("2","增加字典栏目失败");
    }
}
