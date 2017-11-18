package cn.zhku.waterfowl.modules.fowlery.service;

import cn.zhku.waterfowl.pojo.entity.Affiliation;
import cn.zhku.waterfowl.pojo.entity.AffiliationExample;
import cn.zhku.waterfowl.pojo.mapper.AffiliationMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jin on 2017/11/16.
 */
@Service
public class AffiliationService implements IBaseService<Affiliation>{
    @Autowired
    private AffiliationMapper affiliationMapper;     //大禽舍


    @Override
    public int add(Affiliation entity) throws Exception {
        return affiliationMapper.insert(entity);
    }

    @Override
    public int update(Affiliation entity) throws Exception {
        return affiliationMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     *
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public int delete(Affiliation entity) throws Exception {
        return affiliationMapper.updateByPrimaryKey(entity);
    }

    /**
     *
     * @param id
     *            主键ID
     * @return
     * @throws Exception
     */
    @Override
    public Affiliation get(String id) throws Exception {
        return affiliationMapper.selectByPrimaryKey(id);
    }

    /**
     * 暂时不用用到
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public Affiliation get(Affiliation entity) throws Exception {
        return null;
    }

    /**
     * 多条件查询
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public List<Affiliation> findList(Affiliation entity) throws Exception {
        AffiliationExample affiliationExample=new AffiliationExample();
        AffiliationExample.Criteria criteria=affiliationExample.createCriteria();

        //通过size，通过数据字典，有待研究
        if(entity.getSize()!=null){
            criteria.andSizeEqualTo(entity.getSize());
        }
        //通过状态，通过数据字典，有待研究
        if(entity.getStatus()!=null){
            criteria.andStatusEqualTo(entity.getStatus());
        }
        //通过idcharge
        if(entity.getIdCharge()!=null){
            criteria.andIdChargeLike("%"+entity.getIdCharge()+"%");
        }
        //通过idrecord
        if (entity.getIdRecord()!=null){
            criteria.andIdRecordLike("%"+entity.getIdRecord()+"%");
        }
        return affiliationMapper.selectByExample(affiliationExample);
    }
}
