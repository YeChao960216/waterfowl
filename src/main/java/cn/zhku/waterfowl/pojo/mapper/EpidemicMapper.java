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
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int countByExample(EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int deleteByExample(EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int insert(Epidemic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int insertSelective(Epidemic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    List<Epidemic> selectByExample(EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    Epidemic selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") Epidemic record, @Param("example") EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int updateByExample(@Param("record") Epidemic record, @Param("example") EpidemicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int updateByPrimaryKeySelective(Epidemic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table epidemic
     *
     * @mbggenerated Sat Nov 18 10:39:24 CST 2017
     */
    int updateByPrimaryKey(Epidemic record);
}