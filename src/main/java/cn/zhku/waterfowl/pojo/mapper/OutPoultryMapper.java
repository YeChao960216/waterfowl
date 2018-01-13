package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.OutPoultry;
import cn.zhku.waterfowl.pojo.entity.OutPoultryExample;
import cn.zhku.waterfowl.pojo.entity.OutPoultryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutPoultryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int countByExample(OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int deleteByExample(OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int deleteByPrimaryKey(OutPoultryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int insert(OutPoultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int insertSelective(OutPoultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    List<OutPoultry> selectByExample(OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    OutPoultry selectByPrimaryKey(OutPoultryKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int updateByExampleSelective(@Param("record") OutPoultry record, @Param("example") OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int updateByExample(@Param("record") OutPoultry record, @Param("example") OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int updateByPrimaryKeySelective(OutPoultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Jan 13 17:42:50 CST 2018
     */
    int updateByPrimaryKey(OutPoultry record);
}