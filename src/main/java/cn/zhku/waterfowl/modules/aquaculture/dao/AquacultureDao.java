package cn.zhku.waterfowl.modules.aquaculture.dao;

import cn.zhku.waterfowl.modules.aquaculture.model.FeedWeight;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Willon on 2018/1/18.
 */
public interface AquacultureDao {


    @Select("SELECT name, SUM(feed_Weight) feedWeight,weight FROM aquaculture where name <= #{name} and id_patch = #{idPatch}  group by name ,weight")
    List<FeedWeight> feedWeight(@Param("name") int name, @Param("idPatch") String idPatch) ;
}
