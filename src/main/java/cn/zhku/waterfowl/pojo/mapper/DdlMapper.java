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
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int countByExample(DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByExample(DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insert(Ddl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insertSelective(Ddl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    List<Ddl> selectByExample(DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    Ddl selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") Ddl record, @Param("example") DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExample(@Param("record") Ddl record, @Param("example") DdlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKeySelective(Ddl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ddl
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKey(Ddl record);
}