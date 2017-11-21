package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Fowlery;
import cn.zhku.waterfowl.pojo.entity.FowleryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FowleryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int countByExample(FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int deleteByExample(FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int insert(Fowlery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int insertSelective(Fowlery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    List<Fowlery> selectByExample(FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    Fowlery selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int updateByExampleSelective(@Param("record") Fowlery record, @Param("example") FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int updateByExample(@Param("record") Fowlery record, @Param("example") FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int updateByPrimaryKeySelective(Fowlery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Tue Nov 21 22:42:46 CST 2017
     */
    int updateByPrimaryKey(Fowlery record);
}