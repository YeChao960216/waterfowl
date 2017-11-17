package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Affiliation;
import cn.zhku.waterfowl.pojo.entity.AffiliationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AffiliationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int countByExample(AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int deleteByExample(AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int insert(Affiliation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int insertSelective(Affiliation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    List<Affiliation> selectByExample(AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    Affiliation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int updateByExampleSelective(@Param("record") Affiliation record, @Param("example") AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int updateByExample(@Param("record") Affiliation record, @Param("example") AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int updateByPrimaryKeySelective(Affiliation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Thu Nov 16 22:57:41 CST 2017
     */
    int updateByPrimaryKey(Affiliation record);
}