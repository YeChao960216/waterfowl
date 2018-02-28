package cn.zhku.waterfowl.modules.user.service;



import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.pojo.entity.UserExample;
import cn.zhku.waterfowl.pojo.mapper.UserMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author 钱伟健 gonefutre
 * date  :2017/10/14 20:51.
 * E-mail :gonefuture@qq.com
 *
 * service类，业务逻辑在此编写。下面实现了IBaseDao的接口，实现了增删改查。
 */
@Service
public class UserService  implements IBaseService<User> {
    /**
     *  下面都是业务方法，当我们有业务逻辑时，就要重写它们，实现业务逻辑。
     */

    //  注入与表操作相关的mapper,如果报错，应该是ide的问题，可以修改报错等级。
    @Autowired
    private UserMapper userMapper;


    /**
     *  为表增加一个记录
     * @param entity
     *            映射数据库单表的实体类
     * @return User
     * @throws Exception sql
     */
    @Override
    public int add(User entity) throws Exception {
        return userMapper.insert(entity);
    }

    /**
     *  根据参数修改记录
     * @param entity
     *            映射数据库单表的实体类
     * @return  状态码 1 成功， 0 失败
     * @throws Exception    sql
     */
    @Override
    public int update(User entity) throws Exception {
        //  注意：Selective的意思是，如果实体类属性不为空就修改，所以不会出现空值属性覆盖数据库记录
        return userMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     *  根据主键删除记录
     * @param entity
     *            映射数据库单表的实体类
     * @return 状态码 1 成功， 0 失败
     * @throws Exception    sql
     */
    @Override
    public int delete(User entity) throws Exception {
        return userMapper.deleteByPrimaryKey(entity.getId());
    }


    /**
     *  根据主键返回 user
     * @param id
     *            主键ID
     * @return user
     * @throws Exception sql
     */
    @Override
    public User get(String id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     *  根据username属性查找用户
     * @param entity
     *            映射数据库单表的实体类
     * @return user
     * @throws Exception sql
     */
    @Override
    public User get(User entity) throws Exception {
        UserExample userExample = new UserExample();   //   多条件查询时使用的
        if (entity.getUsername() != null) {
             //   相当于where username = entity.getUsername()
            userExample.or().andUsernameEqualTo(entity.getUsername());
            //  使用get(0)的原因是Example参数的东西是集合，但我们只要一个符合条件的记录
            return userMapper.selectByExample(userExample).get(0);
        } else {
            return null;
        }
    }

    /**
     *  处理多条件查询
     * @param entity
     *            映射数据库单表的实体类
     * @return 一列user
     * @throws Exception    sql
     */
    @Override
    public List<User> findList(User entity) throws Exception {
        //  Example相当储放条件的地方，where xxx = xxxx and ccc =ccc
        UserExample userExample = new UserExample();
        //  Criteria是Example的静态子类，里面有条件的jva代码表达方式
        UserExample.Criteria criteria = userExample.createCriteria();

        if (!StringUtils.isBlank(entity.getUsername()))   // 如果username参数不为空，则查询时添加在sql上，
            //  相当于 where username like %entity.getUsername()%
            criteria.andUsernameLike("%"+entity.getUsername()+"%");
        if (!StringUtils.isBlank(entity.getName()))
            //  相当于 type = entity.getName()
            criteria.andNameLike("%"+entity.getName()+"%");
        if (!StringUtils.isBlank(entity.getDuty()))
            //  相当于 duty = entity.getDuty()
            criteria.andDutyEqualTo(entity.getDuty());
        if (entity.getGender() != null)
            //  相当于 duty = entity.getDuty()
            criteria.andGenderEqualTo(entity.getGender());
        if (!StringUtils.isBlank(entity.getSign()))
            //  相当于 Sign = entity.getSign()
            criteria.andSignEqualTo(entity.getSign());

        return userMapper.selectByExample(userExample);
    }

}
