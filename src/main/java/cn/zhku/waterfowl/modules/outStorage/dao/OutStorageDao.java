package cn.zhku.waterfowl.modules.outStorage.dao;

import cn.zhku.waterfowl.pojo.entity.Material;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OutStorageDao {
    /*
     * 根据type是否为'未过期'和'已过期'
     * */
    @Select("select * from material where name like concat('%',#{name},'%') and type='未过期'")
    List<Material> listMatericalByName(String name);
//    /*
//     * 根据type是否为'未过期'和'已过期'
//     * */
//    @Select("select * from material where name like concat('%',#{name},'%') and type='未过期'")
//    List<Material> listMatericalByName(String name);
}
