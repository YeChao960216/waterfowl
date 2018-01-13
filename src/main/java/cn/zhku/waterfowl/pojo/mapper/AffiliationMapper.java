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
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int countByExample(AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int deleteByExample(AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int insert(Affiliation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int insertSelective(Affiliation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    List<Affiliation> selectByExample(AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    Affiliation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int updateByExampleSelective(@Param("record") Affiliation record, @Param("example") AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int updateByExample(@Param("record") Affiliation record, @Param("example") AffiliationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int updateByPrimaryKeySelective(Affiliation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table affiliation
     *
     * @mbggenerated Sat Jan 13 23:03:32 CST 2018
     */
    int updateByPrimaryKey(Affiliation record);
}