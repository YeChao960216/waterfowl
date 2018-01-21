package cn.zhku.waterfowl.modules.dictionary.dao;

import cn.zhku.waterfowl.pojo.entity.Dictionary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 叶超 on 2018/1/19 0019.
 */
public interface DictionaryDao {
    @Select("select id from dictionary where pid=#{pid} order by id")
    List<Dictionary> addid(String pid);
    @Select("delete * from dictionary where pid=#{pid}")
    void deleteAll(String pid);
}
