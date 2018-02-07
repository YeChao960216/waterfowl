package cn.zhku.waterfowl.modules.patch.service;

import cn.zhku.waterfowl.modules.patch.dao.PatchDao;
import cn.zhku.waterfowl.pojo.entity.*;
import cn.zhku.waterfowl.pojo.mapper.PatchMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.apache.commons.lang3.StringUtils;
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
    @Autowired
    private PatchDao dao;

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
        return patchMapper.deleteByPrimaryKey(entity.getId());
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
        if(StringUtils.isNotBlank(entity.getType())){
            criteria.andTypeEqualTo(entity.getType());
        }
        //通过idPoutry
        if(StringUtils.isNotBlank(entity.getIdPoultry())){
            criteria.andIdPoultryEqualTo(entity.getIdPoultry());
        }
        //通过status
        if(StringUtils.isNotBlank(entity.getStatus())){
            criteria.andStatusEqualTo(entity.getStatus());
        }
        //通过size
        if(entity.getSize()!= null){
            criteria.andSizeEqualTo(entity.getSize());
        }
        //通过position
        if(StringUtils.isNotBlank(entity.getPosition())){
            criteria.andPositionEqualTo(entity.getPosition());
        }
        //通过idcharger
        if(entity.getIdCharge()!= null){
            criteria.andIdChargeLike("%"+entity.getIdCharge()+"%");
        }
        //通过idrecorder
        if(StringUtils.isNotBlank(entity.getIdRecorder())){
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        }

        if (StringUtils.isNotBlank(entity.getIdPoultry())) {
            criteria.andIdPoultryEqualTo(entity.getIdPoultry());
        }
        return patchMapper.selectByExample(patchExample);
    }


    /**
     * 通过affiliation查找到小禽舍信息
     * @param affiliation
     * @return
     */
    public List<Fowlery> selectFowlery(String affiliation) {
        return  dao.selectFowlery(affiliation);
    }

    /**
     * 修改小禽舍的状态
     * @param id
     */
    public int updateStatusByid(String id) {
        return dao.updateStatusByid(id);
    }

    /**
     * 获取禽舍中最新的一条记录
     * @return
     */
    public String getNewPatch() {
        return dao.getNewPatch();
    }

    /**
     * 通过id_poultry找到patch的id集合
     * @param id_poultry
     * @return
     */
    public List<String> findPatch(String id_poultry) {
        return dao.findPatch(id_poultry);
    }


    /**
     * poultry中的总数量
     * @return
     */
    public String findQuantity(String id_poultry) {
        return dao.findQuantity(id_poultry);
    }

//    public List<Affiliation> listAffiliationid(Affiliation entity)throws Exception {
//        AffiliationExample affiliationExample=new AffiliationExample();
//        entity.getType();
//        entity.getPosition();
//        List<Affiliation> affiliationList = new ArrayList<Affiliation>(affiliationMapper.selectByExample(entity.getType(),entity.getPosition());
//    }
//
//    public List<Affiliation> listAffiliationid(String position,String type)throws Exception {
//        return dao.listAffiliationid(position,type);
//    }
}
