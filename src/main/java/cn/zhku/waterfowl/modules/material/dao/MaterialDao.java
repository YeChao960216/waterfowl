//package cn.zhku.waterfowl.modules.material.dao;
//
//import cn.zhku.waterfowl.pojo.entity.Outstorage;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
//public interface MaterialDao {
//    @Select("update outStorage set outStorage.quantity=outStorage.quantity+#{quantity} where name=#{name} and remark=#{remark} and type=#{type}")
//    void updateQuantity(float quantity,String name,String remark,String type);
//    @Select("select id_outstorage from outStorage where name=#{name} and remark=#{remark}")
//    String listOutstorageid(String name, String remark);
//    @Select("update outStorage set outStorage.quantity=outStorage.quantity-#{quantity} where name=#{name} and remark=#{remark} and type=#{type}")
//    void updateNum(float quantity,String name,String remark,String type);
//}
