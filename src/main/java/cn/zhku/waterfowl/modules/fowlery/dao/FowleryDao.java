package cn.zhku.waterfowl.modules.fowlery.dao;

import cn.zhku.waterfowl.pojo.entity.Affiliation;
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
     * 通过类型，位置，大小找到相应的归属表的记录,有多条记录
     * @param type
     * @param position
     * @param size
     * @return
     */
    @Select(" SELECT * FROM affiliation WHERE type=#{type} AND position=#{position} AND size=#{size}")
    List<Affiliation> selectAffiliation(String type, String position, String size);

    /**
     *通过poultry的id查看这个初批次有多少只
     * @param id_poultry
     * @return
     */
    @Select("SELECT quantity from poultry where id_poultry=#{id}")
    String getCount(String id_poultry);


    /**
     *通过affiliation的id获取小禽舍
     * @param affiliation
     * @return
     */
    @Select("select * from fowlery where affiliation=#{id}")
    List<Fowlery> selectFowlery(String affiliation);

    /**
     * 通过id_poultry查看一个size的list集合
     * @param id_poultry
     * @return
     */
    @Select("select size from fowlery where id=ANY(select id_fowlery from patch WHERE id_poultry=#{id_poultry})")
    List<String> getFowlerySize(String id_poultry);

    /**
     * 根据size查找数据字典
     * @param s
     * @return
     */
    @Select("SELECT remark from dictionary where id=s")
    String selectSizeByDic(String s);

    @Select("SELECT id from out_poultry where id_patch=(SELECT  id from patch where id_fowlery=#{id})")
    String selectFowleryStatus(String id);
}
