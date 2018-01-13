package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.pojo.entity.PoultryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoultryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int countByExample(PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int deleteByExample(PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int deleteByPrimaryKey(String idPoultry);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int insert(Poultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int insertSelective(Poultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    List<Poultry> selectByExample(PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    Poultry selectByPrimaryKey(String idPoultry);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int updateByExampleSelective(@Param("record") Poultry record, @Param("example") PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int updateByExample(@Param("record") Poultry record, @Param("example") PoultryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int updateByPrimaryKeySelective(Poultry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poultry
     *
     * @mbggenerated Sat Jan 13 19:54:18 CST 2018
     */
    int updateByPrimaryKey(Poultry record);
}