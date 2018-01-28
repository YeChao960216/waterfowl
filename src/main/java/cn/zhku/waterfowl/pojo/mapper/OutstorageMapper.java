package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.entity.OutstorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutstorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int countByExample(OutstorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int deleteByExample(OutstorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int deleteByPrimaryKey(String idOutstorage);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int insert(Outstorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int insertSelective(Outstorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    List<Outstorage> selectByExample(OutstorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    Outstorage selectByPrimaryKey(String idOutstorage);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int updateByExampleSelective(@Param("record") Outstorage record, @Param("example") OutstorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int updateByExample(@Param("record") Outstorage record, @Param("example") OutstorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int updateByPrimaryKeySelective(Outstorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outstorage
     *
     * @mbggenerated Sun Jan 28 21:23:28 CST 2018
     */
    int updateByPrimaryKey(Outstorage record);
}