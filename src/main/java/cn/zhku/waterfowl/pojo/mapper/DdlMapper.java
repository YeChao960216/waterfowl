package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Ddl;
import cn.zhku.waterfowl.pojo.entity.DdlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DdlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int countByExample(DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int deleteByExample(DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int insert(Ddl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int insertSelective(Ddl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    List<Ddl> selectByExample(DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    Ddl selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int updateByExampleSelective(@Param("record") Ddl record, @Param("example") DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int updateByExample(@Param("record") Ddl record, @Param("example") DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int updateByPrimaryKeySelective(Ddl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Mon Oct 23 19:52:23 CST 2017
     */
    int updateByPrimaryKey(Ddl record);
}