package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.EpiStor;
import cn.zhku.waterfowl.pojo.entity.EpiStorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpiStorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int countByExample(EpiStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByExample(EpiStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByPrimaryKey(String eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insert(EpiStor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insertSelective(EpiStor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    List<EpiStor> selectByExample(EpiStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    EpiStor selectByPrimaryKey(String eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") EpiStor record, @Param("example") EpiStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExample(@Param("record") EpiStor record, @Param("example") EpiStorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKeySelective(EpiStor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epi_stor
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKey(EpiStor record);
}