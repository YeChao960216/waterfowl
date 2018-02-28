package cn.zhku.waterfowl.modules.epiStor.service;

import cn.zhku.waterfowl.pojo.entity.EpiStor;
import cn.zhku.waterfowl.pojo.entity.EpiStorExample;
import cn.zhku.waterfowl.pojo.mapper.EpiStorMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EpiStorService implements IBaseService<EpiStor> {
    @Autowired
    private EpiStorMapper epiStorMapper;

    @Override
    public int add(EpiStor entity) throws Exception {
        return epiStorMapper.insert(entity);
    }

    @Override
    public int update(EpiStor entity) throws Exception {
        return epiStorMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(EpiStor entity) throws Exception {
        return epiStorMapper.deleteByPrimaryKey(entity.getEid());
    }

    @Override
    public EpiStor get(String id) throws Exception {
        return epiStorMapper.selectByPrimaryKey(id);
    }

    @Override
    public EpiStor get(EpiStor entity) throws Exception {
        EpiStorExample epiStorExample=new EpiStorExample();
        epiStorExample.or().andIdEqualTo(entity.getEid());
        return null;
    }


    @Override
    public List<EpiStor> findList(EpiStor entity) throws Exception {
        EpiStorExample epiStorExample=new EpiStorExample();
        EpiStorExample.Criteria criteria=epiStorExample.createCriteria();
        if (entity.getId() != null)
            criteria.andIdEqualTo(entity.getId());
        if (entity.getIdOutstorage() != null)
            criteria.andIdOutstorageEqualTo(entity.getIdOutstorage());
        return epiStorMapper.selectByExample(epiStorExample);
    }
}
