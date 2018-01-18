/*package cn.zhku.waterfowl.modules.epiStor.service;

import cn.zhku.waterfowl.pojo.entity.EpiStor;
import cn.zhku.waterfowl.pojo.entity.EpiStorExample;
import cn.zhku.waterfowl.pojo.mapper.EpiStorMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*//**
 * Created by Administrator on 2018/1/17 0017.
 *//*
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
        return epiStorMapper.deleteByPrimaryKey(entity.getKey());
    }

    @Override
    public EpiStor get(String id) throws Exception {
        return epiStorMapper.selectByPrimaryKey(id);
    }

    @Override
    public EpiStor get(EpiStor entity) throws Exception {
        EpiStorExample epiStorExample=new EpiStorExample()

        return null;


    @Override
    public List<EpiStor> findList(EpiStor entity) throws Exception {
        return null;
    }
}*/
