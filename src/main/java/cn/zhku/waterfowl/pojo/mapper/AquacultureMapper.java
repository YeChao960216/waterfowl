package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.AquacultureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AquacultureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int countByExample(AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int deleteByExample(AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int insert(Aquaculture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int insertSelective(Aquaculture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    List<Aquaculture> selectByExample(AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    Aquaculture selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") Aquaculture record, @Param("example") AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int updateByExample(@Param("record") Aquaculture record, @Param("example") AquacultureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int updateByPrimaryKeySelective(Aquaculture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aquaculture
     *
     * @mbggenerated Tue Jan 16 17:46:06 CST 2018
     */
    int updateByPrimaryKey(Aquaculture record);
}