package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.ManOutpou;
import cn.zhku.waterfowl.pojo.entity.ManOutpouExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManOutpouMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int countByExample(ManOutpouExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int deleteByExample(ManOutpouExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int insert(ManOutpou record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int insertSelective(ManOutpou record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    List<ManOutpou> selectByExample(ManOutpouExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    ManOutpou selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") ManOutpou record, @Param("example") ManOutpouExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByExample(@Param("record") ManOutpou record, @Param("example") ManOutpouExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByPrimaryKeySelective(ManOutpou record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table man_outpou
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByPrimaryKey(ManOutpou record);
}