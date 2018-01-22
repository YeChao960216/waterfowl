package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.AquaStor;
import cn.zhku.waterfowl.pojo.entity.AquaStorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AquaStorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int countByExample(AquaStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int deleteByExample(AquaStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int deleteByPrimaryKey(String aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int insert(AquaStor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int insertSelective(AquaStor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    List<AquaStor> selectByExample(AquaStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    AquaStor selectByPrimaryKey(String aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") AquaStor record, @Param("example") AquaStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByExample(@Param("record") AquaStor record, @Param("example") AquaStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByPrimaryKeySelective(AquaStor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aqua_stor
     *
     * @mbggenerated Mon Jan 22 13:26:24 CST 2018
     */
    int updateByPrimaryKey(AquaStor record);
}