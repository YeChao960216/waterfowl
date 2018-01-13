package cn.zhku.waterfowl.pojo.mapper;

import cn.zhku.waterfowl.pojo.entity.UserAuths;
import cn.zhku.waterfowl.pojo.entity.UserAuthsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int countByExample(UserAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int deleteByExample(UserAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int insert(UserAuths record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int insertSelective(UserAuths record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    List<UserAuths> selectByExample(UserAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    UserAuths selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserAuths record, @Param("example") UserAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int updateByExample(@Param("record") UserAuths record, @Param("example") UserAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int updateByPrimaryKeySelective(UserAuths record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auths
     *
     * @mbggenerated Sat Jan 13 18:33:04 CST 2018
     */
    int updateByPrimaryKey(UserAuths record);
}