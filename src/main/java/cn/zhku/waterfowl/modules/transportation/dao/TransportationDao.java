package cn.zhku.waterfowl.modules.transportation.dao;

import cn.zhku.waterfowl.pojo.entity.Customer;
import cn.zhku.waterfowl.pojo.entity.Patch;
import cn.zhku.waterfowl.pojo.entity.Transportation;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author： 成君 943193747@qq.com .
 * @Date： 2018/1/28 0028  15:40.
 */
public interface TransportationDao {

    /**
     * 更改批次状态为运输阶段
     * @param idPacth
     */
    @Update("update patch set status = '30007' where id_poultry = #{idPacth}")
    void setPatchStatus(String idPacth);

    /**
     * 更改批次状态为完成
     * @param idPatch
     */
    @Update("update out_poultry set status = '30014' where id = #{idPacth}")
    int setPatchStatusFinish(String idPatch);

    /**
     * 获取顾客的地址的经纬度
     * @param id
     * @return
     */
    @Select("select lng,lat from customer where cid = #{id}")
    List<Customer> getLanAndLat(String id);

}