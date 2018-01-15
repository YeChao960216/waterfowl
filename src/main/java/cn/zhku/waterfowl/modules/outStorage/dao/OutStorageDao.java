package cn.zhku.waterfowl.modules.outStorage.dao;

import cn.zhku.waterfowl.pojo.entity.Outstorage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OutStorageDao {
    @Select("select outStorage from outstorage where name like concat('%',#{name},'%') where valid='未过期'")
    List<Outstorage> listOutstorageByName(String name);
//    @Select("update outStorage set outStorage.quantity=outStorage.quantity+#{quantity} where name=#{name} and remark=#{remark} and type=#{type}")
//    void updateQuantity(float quantity,String name,String remark,String type);
//    @Select("select id_outstorage from outStorage where name=#{name} and remark=#{remark}")
//    String listOutstorageid(String name, String remark);
//    @Select("update outStorage set outStorage.quantity=outStorage.quantity-#{quantity} where name=#{name} and remark=#{remark} and type=#{type}")
//    void updateNum(float quantity,String name,String remark,String type);
}
