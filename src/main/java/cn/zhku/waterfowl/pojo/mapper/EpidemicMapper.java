package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Epidemic;
import cn.zhku.waterfowl.pojo.entity.EpidemicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int countByExample(EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByExample(EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insert(Epidemic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insertSelective(Epidemic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    List<Epidemic> selectByExample(EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    Epidemic selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") Epidemic record, @Param("example") EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExample(@Param("record") Epidemic record, @Param("example") EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKeySelective(Epidemic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKey(Epidemic record);
}