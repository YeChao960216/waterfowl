package cn.zhku.waterfowl.modules.fowlery.service;

import cn.zhku.waterfowl.modules.fowlery.dao.FowleryDao;
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
    private FowleryDao dao;

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
        return fowleryMapper.deleteByPrimaryKey(entity.getId());
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
     * 通过实体映射
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public Fowlery get(Fowlery entity) throws Exception {
        return null;
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
        //通过size
        if(entity.getAffiliation()!=null){
            criteria.andAffiliationEqualTo(entity.getAffiliation());
        }
        if(entity.getName()!=null){
            criteria.andNameEqualTo(entity.getName());
        }
        //通过size
        if(entity.getSize()!=null){
            criteria.andSizeEqualTo(entity.getSize());
        }
        //通过状态
        if(entity.getStatus()!=null){
            criteria.andStatusEqualTo(entity.getStatus());
        }
        //通过idcharge
        if(entity.getIdCharge()!=null){
            criteria.andIdChargeLike("%"+entity.getIdCharge()+"%");
        }
        //通过idrecord
        if(entity.getIdRecord()!=null){
            criteria.andIdChargeLike( "%"+entity.getIdRecord()+"%");
        }

        return fowleryMapper.selectByExample(fowleryExample);
    }

    /**
     * 通过affiliation的id查找的到对应的fowlery
     * @param id
     * @return
     */
    public List<Fowlery> findFowleryByAId(String id) {
        Fowlery fowlery=new Fowlery();
        fowlery.setAffiliation(id);

        return dao.findFowleryByAId(id);
    }

    /**
     * 计算所有禽舍的数量
     * @return
     */
    public int countAllFowlery() {
        FowleryExample fowleryExample=new FowleryExample();
        return fowleryMapper.countByExample(fowleryExample);
    }

    /**
     * 计算已经被使用过的禽舍的数量
     * @return
     */
    public int countUsedFowlery() {
        FowleryExample fowleryExample=new FowleryExample();
        FowleryExample.Criteria criteria=fowleryExample.createCriteria();
        criteria.andStatusEqualTo("不可使用");
        return fowleryMapper.countByExample(fowleryExample);
    }
}
