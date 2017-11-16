package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.pojo.entity.PoultryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoultryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int countByExample(PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int deleteByExample(PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int deleteByPrimaryKey(String idPoultry);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int insert(Poultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int insertSelective(Poultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    List<Poultry> selectByExample(PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    Poultry selectByPrimaryKey(String idPoultry);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int updateByExampleSelective(@Param("record") Poultry record, @Param("example") PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int updateByExample(@Param("record") Poultry record, @Param("example") PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int updateByPrimaryKeySelective(Poultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Thu Nov 16 16:51:03 CST 2017
     */
    int updateByPrimaryKey(Poultry record);
}