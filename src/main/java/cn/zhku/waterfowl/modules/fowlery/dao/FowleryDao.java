package cn.zhku.waterfowl.modules.fowlery.dao;

import cn.zhku.waterfowl.pojo.entity.Fowlery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jin on 2017/11/19.
 */
public interface FowleryDao {
    /**
     *通过affiliation的id查找的到对应的fowlery
     * @param id
     * @return
     */
    @Select("select * from fowlery where affiliation=#{id}")
    List<Fowlery> findFowleryByAId(String id);


    /**
     * 查找类型
     * @return
     */
    @Select("select id from dictionary where pid=70000")
    List<String> selectSize();


    /**
     * 查找小禽舍的地址
     * @return
     */
    @Select("select id from dictionary where pid=80000")
    List<String> selectPosition();


    /**
     * 查找类型
     * @return
     */
    @Select("select id from dictionary where pid=60000")
    List<String> selectType();

}
