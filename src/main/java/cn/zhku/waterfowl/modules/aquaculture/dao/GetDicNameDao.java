package cn.zhku.waterfowl.modules.aquaculture.dao;

import cn.zhku.waterfowl.pojo.entity.Dictionary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 成君
 * @date 21:25 2017/11/21 0021
 * @E-mail 943193747@qq.com
 */
public interface GetDicNameDao {

    /**
     * 返回name
     * @return list
     */
    @Select("select name from dictionary where pid=#{pid}")
    List<Dictionary> getStatus(String pid);
}
