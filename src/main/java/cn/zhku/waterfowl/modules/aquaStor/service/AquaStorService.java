package cn.zhku.waterfowl.modules.aquaStor.service;

import cn.zhku.waterfowl.pojo.entity.AquaStor;
import cn.zhku.waterfowl.pojo.entity.AquaStorExample;
import cn.zhku.waterfowl.pojo.mapper.AquaStorMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
@Service
public class AquaStorService implements IBaseService<AquaStor>{
    @Autowired
    private AquaStorMapper aquaStorMapper;

    @Override
    public int add(AquaStor entity) throws Exception {
        return aquaStorMapper.insert(entity);
    }

    @Override
    public int update(AquaStor entity) throws Exception {
        return aquaStorMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(AquaStor entity) throws Exception {
        return aquaStorMapper.deleteByPrimaryKey(entity.getAid());
    }

    @Override
    public AquaStor get(String id) throws Exception {
        return aquaStorMapper.selectByPrimaryKey(id);
    }

    @Override
    public AquaStor get(AquaStor entity) throws Exception {
        AquaStorExample aquaStorExample=new AquaStorExample();
        aquaStorExample.or().andIdEqualTo(entity.getAid());
        return aquaStorMapper.selectByExample(aquaStorExample).get(0);
    }

    @Override
    public List<AquaStor> findList(AquaStor entity) throws Exception {
        AquaStorExample aquaStorExample=new AquaStorExample();
        AquaStorExample.Criteria criteria = aquaStorExample.createCriteria();
        if (entity.getId() != null&&!entity.getId().equals(""))
            criteria.andIdEqualTo(entity.getId());
        if (entity.getIdOutstorage() != null&&!entity.getIdOutstorage().equals(""))
            criteria.andIdOutstorageEqualTo(entity.getIdOutstorage());
        return aquaStorMapper.selectByExample(aquaStorExample);
    }
}
