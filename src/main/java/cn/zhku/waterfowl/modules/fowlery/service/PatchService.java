package cn.zhku.waterfowl.modules.fowlery.service;

import cn.zhku.waterfowl.pojo.entity.Patch;
import cn.zhku.waterfowl.pojo.entity.PatchExample;
import cn.zhku.waterfowl.pojo.mapper.PatchMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jin on 2017/11/17.
 */
@Service
public class PatchService implements IBaseService<Patch>{
    @Autowired
    private PatchMapper patchMapper;

    @Override
    public int add(Patch entity) throws Exception {
        return patchMapper.insert(entity);
    }

    @Override
    public int update(Patch entity) throws Exception {
        return patchMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(Patch entity) throws Exception {
        return patchMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Patch get(String id) throws Exception {
        return patchMapper.selectByPrimaryKey(id);
    }


    @Override
    public Patch get(Patch entity) throws Exception {
        return null;
    }

    @Override
    public List<Patch> findList(Patch entity) throws Exception {
        PatchExample patchExample=new PatchExample();
        PatchExample.Criteria criteria=patchExample.createCriteria();

        //通过type
        if(entity.getType()!=null){
            criteria.andTypeLike("%"+entity.getType()+"%");
        }
        //通过size
        if(entity.getSize()!=null){
            criteria.andSizeEqualTo(entity.getSize());
        }
        //通过position
        if(entity.getPosition()!=null){
            criteria.andPositionLike("%"+entity.getPosition()+"%");
        }
        //通过idcharger
        if(entity.getIdCharge()!=null){
            criteria.andIdChargeLike("%"+entity.getIdCharge()+"%");
        }
        //通过idrecorder
        if(entity.getIdRecorder()!=null){
            criteria.andIdRecorderLike("%"+entity.getIdRecorder()+"%");
        }
        return patchMapper.selectByExample(patchExample);
    }
}
