package cn.zhku.waterfowl.modules.outStorage.dao;

import cn.zhku.waterfowl.pojo.entity.Outstorage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface OutStorageDao {
    //根据outstorage的模糊物资名并且是未过期的找到那条信息的生产厂家
    @Select("select firm from outstorage where name like concat('%',#{name},'%') where valid='未过期'")
    List<Outstorage> listOutstorageByName(String name);

    @Select("update name from outStorage.quantity=outStorage.quantity+#{quantity} where name=#{name} and remark=#{remark} and type=#{type}")
    void updateQuantity(float quantity,String name,String remark,String type);

    //查询type
    @Select("select * from outStorage where name=#{name} and firm=#{firm} where valid='未过期'")
    List<Outstorage> listType(String name,String firm);

    @Select("select distinct name,firm from outstorage where type=#{type}")
    List<Outstorage> Listname(String type);

    //优先调度有效期快过期物资
    @Select("select * from outstorage where name=#{name} and firm=#{firm} and valid='未过期' and rest>0 order by expiration_date" )
    List<Outstorage> manageOutstorage(@Param("name") String name, @Param("firm") String firm, float quantity);
}
