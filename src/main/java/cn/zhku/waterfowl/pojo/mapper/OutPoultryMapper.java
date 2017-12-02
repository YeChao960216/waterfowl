package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.OutPoultry;
import cn.zhku.waterfowl.pojo.entity.OutPoultryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutPoultryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int countByExample(OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int deleteByExample(OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int insert(OutPoultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int insertSelective(OutPoultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    List<OutPoultry> selectByExample(OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    OutPoultry selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int updateByExampleSelective(@Param("record") OutPoultry record, @Param("example") OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int updateByExample(@Param("record") OutPoultry record, @Param("example") OutPoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int updateByPrimaryKeySelective(OutPoultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table out_poultry
     *
     * @mbggenerated Sat Dec 02 20:46:38 CST 2017
     */
    int updateByPrimaryKey(OutPoultry record);
}