package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.Storage;
import cn.zhku.waterfowl.pojo.entity.StorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int countByExample(StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int deleteByExample(StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int deleteByPrimaryKey(String idStorage);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int insert(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int insertSelective(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    List<Storage> selectByExample(StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    Storage selectByPrimaryKey(String idStorage);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int updateByPrimaryKeySelective(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbggenerated Fri Nov 03 19:21:03 CST 2017
     */
    int updateByPrimaryKey(Storage record);
}