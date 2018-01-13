package cn.zhku.waterfowl.modules.aquaculture.dao;

import cn.zhku.waterfowl.pojo.entity.Material;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 成君
 * Created by weakness on 2018/1/12 0012.
 * @E-mail 943193747@qq.com
 */
public interface CheckQuantitydao {
    /**
     * 返回个啥
     * @param name
     * @param remark
     * @return
     */
    @Select("SELECT quantity from outStorage where name=#{name} and remark=#{remark}")
    float checkQuantity(String name,String remark);

    /**
     * 修改已有数量
     * @param quantity
     */
    @Select("update outStorage set outStorage.quantity=outStorage.quantity-#{quantity} where name=#{name} and remark=#{remark}")
    void updateQuantity(float quantity,String name,String remark);

    @Select("select remark from outStorage where name like concat('%',#{name},'%')")
    List<Outstorage> listOutstorageByname(String name);

    @Select("select id_outstorage from outStorage where name=#{name} and remark=#{remark} limit 1")
    List<Outstorage> listOutstorageid(String name,String remark);
}
