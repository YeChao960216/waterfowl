package cn.zhku.waterfowl.modules.fowlery.service;

import cn.zhku.waterfowl.pojo.entity.Fowler;
import cn.zhku.waterfowl.pojo.entity.FowleryExample;
import cn.zhku.waterfowl.pojo.mapper.FowleryMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jin on 2017/10/24.
 */
@Service
public class FowleryService implements IBaseService<Fowler> {
    @Autowired
    private FowleryMapper fowleryMapper;

    @Override
    public int add(Fowler entity) throws Exception {
        return fowleryMapper.insert(entity);
    }

    @Override
    public int update(Fowler entity) throws Exception {
        return fowleryMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(Fowler entity) throws Exception {
        return fowleryMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Fowler get(String id) throws Exception {
        return fowleryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Fowler get(Fowler entity) throws Exception {
        FowleryExample fowleryExample=new FowleryExample();
        if(entity.getIdCharge()!=null){
            fowleryExample.or().andIdChargeEqualTo(fowleryExample);   //?????
            return fowleryMapper.selectByExample(fowleryExample).get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Fowler> findList(Fowler entity) throws Exception {
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
}
