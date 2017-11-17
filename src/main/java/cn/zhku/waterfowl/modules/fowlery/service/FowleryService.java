package cn.zhku.waterfowl.modules.fowlery.service;

import cn.zhku.waterfowl.pojo.entity.Fowlery;
import cn.zhku.waterfowl.pojo.entity.FowleryExample;
import cn.zhku.waterfowl.pojo.mapper.FowleryMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jin on 2017/10/24.
 *
 */
@Service
public class FowleryService implements IBaseService<Fowlery> {
    @Autowired
    private FowleryMapper fowleryMapper;

    @Override
    public int add(Fowlery entity) throws Exception {
        return fowleryMapper.insert(entity);
    }

    /**
     * 修改禽舍信息
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public int update(Fowlery entity) throws Exception {
        return fowleryMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 删除禽舍信息
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public int delete(Fowlery entity) throws Exception {
        return fowleryMapper.updateByPrimaryKey(entity);
    }

    /**
     *
     * @param id
     *            主键ID
     * @return
     * @throws Exception
     */
    @Override
    public Fowlery get(String id) throws Exception {
        return fowleryMapper.selectByPrimaryKey(id);
    }

    /**
     *通过地址查找禽舍
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public Fowlery get(Fowlery entity) throws Exception {
        FowleryExample fowleryExample=new FowleryExample();
        if(entity.getIdCharge()!=null){
            fowleryExample.or().andIdChargeEqualTo(entity.getAddress());
            return fowleryMapper.selectByExample(fowleryExample).get(0);
        }else{
            return null;
        }
    }

    /**
     * 展示，多条件查询,模糊查询
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public List<Fowlery> findList(Fowlery entity) throws Exception {
        FowleryExample fowleryExample=new FowleryExample();
        FowleryExample.Criteria criteria=fowleryExample.createCriteria();

        if(entity.getIdCharge()!=null){
            criteria.andIdChargeLike("%"+entity.getIdCharge()+"%");
        }
        if(entity.getAddress()!=null){
            criteria.andAddressLike("%"+entity.getAddress()+"%");
        }
        return fowleryMapper.selectByExample(fowleryExample);
    }

    /**
     * 通过id查找鸡舍
     * @param type
     * @return id
     */
    public List<String> getType(String type) {
        return fowleryMapper.findFowleryIdByType(type);
    }

    /**
     * 查找禽舍最大的容纳量
     * @param id
     * @return
     */
    public Integer findMaxNumById(String id) {
        return fowleryMapper.findMaxNumById(id);
    }

    /**
     * 查看已经存放的有多少
     * @param id
     * @return 存放的数量
     */
    public Integer findUsedNumById(String id) {
        return fowleryMapper.findUsedNumById(id);
    }
}
