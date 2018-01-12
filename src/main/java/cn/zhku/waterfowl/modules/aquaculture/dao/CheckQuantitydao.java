package cn.zhku.waterfowl.modules.aquaculture.dao;

import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT quantity from outStorage where name=#{name} and remark=#{remark} and type='未过期'")
    float checkQuantity(String name,String remark);

    /**
     * 修改已有数量
     * @param quantity
     */
    @Select("update outStorage set outStorage.quantity=outStorage.quantity-#{quantity} where name=#{name} and remark=#{remark} and type='未过期'")
    void updateQuantity(float quantity,String name,String remark);
}
