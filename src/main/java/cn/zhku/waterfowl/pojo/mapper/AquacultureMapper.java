package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.AquacultureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AquacultureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int countByExample(AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int deleteByExample(AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int insert(Aquaculture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int insertSelective(Aquaculture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    List<Aquaculture> selectByExample(AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    Aquaculture selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int updateByExampleSelective(@Param("record") Aquaculture record, @Param("example") AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int updateByExample(@Param("record") Aquaculture record, @Param("example") AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int updateByPrimaryKeySelective(Aquaculture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Wed Nov 22 23:05:16 CST 2017
     */
    int updateByPrimaryKey(Aquaculture record);
}