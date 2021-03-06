package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Weather;
import cn.zhku.waterfowl.pojo.entity.WeatherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int countByExample(WeatherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByExample(WeatherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insert(Weather record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int insertSelective(Weather record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    List<Weather> selectByExample(WeatherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    Weather selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") Weather record, @Param("example") WeatherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByExample(@Param("record") Weather record, @Param("example") WeatherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKeySelective(Weather record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather
     *
     * @mbggenerated Sun Feb 04 21:51:04 CST 2018
     */
    int updateByPrimaryKey(Weather record);
}