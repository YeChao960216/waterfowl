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
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int countByExample(FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByExample(FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insert(Fowlery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insertSelective(Fowlery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    List<Fowlery> selectByExample(FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    Fowlery selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") Fowlery record, @Param("example") FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExample(@Param("record") Fowlery record, @Param("example") FowleryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKeySelective(Fowlery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fowlery
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKey(Fowlery record);
}