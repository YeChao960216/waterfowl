package cn.zhku.waterfowl.modules.patch.dao;

import cn.zhku.waterfowl.pojo.entity.Fowlery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jin on 2018/1/11.
 */
public interface PatchDao {
    /**
     * 获取禽舍中最新的一条记录
     * @return
     */
    @Select("select id from patch GROUP BY date desc LIMIT 1")
    String getNewPatch();

    /**
     * 修改小禽舍的状态为不可使用
     * @param id
     */
    @Select("update fowlery set status='不可使用' where id=#{id}")
    int updateStatusByid(String id);

    /**
     *通过affiliation的id获取小禽舍
     * @param affiliation
     * @return
     */
    @Select("select * from fowlery where affiliation=#{affiliation} and status='可使用'")
    List<Fowlery> selectFowlery(String affiliation);

    /**
     * 通过id_poultry找到patch的id集合
     * @param id_poultry
     * @return
     */
    @Select("select id from patch where id_poultry=#{id_poultry}")
    List<String> findPatch(String id_poultry);

    /**
     * 该禽舍中存放的数量
     * 先找到size,再去字典中查找size的大小是多少
     * @param id
     * @return
     */
    @Select("select name from dictionary where id=( select size from patch where id=#{id})")
    String findSize(String id);

    /**
     * poultry中的总数量
     * @param id_poultry
     * @return
     */
    @Select("select quantity from poultry where id_poultry=#{id_poultry}")
    String findQuantity(String id_poultry);

    /*
    * 查找出可以养殖完成的批次号
    * author:yechao
    * */
    @Select("SELECT id FROM patch WHERE id=(SELECT id_patch FROM aquaculture WHERE status=30003) and id_poultry=#{id_poultry}")
    List<String> findOutpoultry(String id_poultry);
}
