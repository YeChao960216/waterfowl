package cn.zhku.waterfowl.modules.outStorage.service;

import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.entity.OutstorageExample;
import cn.zhku.waterfowl.pojo.mapper.OutstorageMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutStorageService  implements IBaseService<Outstorage> {
    @Autowired
    private OutstorageMapper outstorageMapper;
    @Autowired
    private OutStorageDao outStorageDao;
    @Override
    /**
     * 根据storage实体插入
     */
    public int add(Outstorage entity) throws Exception {
        return outstorageMapper.insert(entity);
    }

    @Override
    /**
     * 根据storage实体更新
     * @param entity 映射数据库单表的实体类
     * @return
     */
    public int update(Outstorage entity) throws Exception {
        return outstorageMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    /**
     *根据storage实体类id删除
     * @param entity 映射数据库单表的实体类
     * @return
     */
    public int delete(Outstorage entity) throws Exception {

        return outstorageMapper.deleteByPrimaryKey(entity.getIdStorage());

    }

    @Override
    /**
     * 根据id得到epdemic实体类
     */
    public Outstorage get(String idOutstorage) throws Exception {
        return outstorageMapper.selectByPrimaryKey(idOutstorage);
    }

    @Override
    /**
     * 根据epdemic实体类的id查询
     */
    public Outstorage get(Outstorage entity) throws Exception {
        OutstorageExample outstorageExample =new OutstorageExample();
        outstorageExample.or().andIdOutstorageEqualTo(entity.getIdOutstorage());
        if (outstorageExample!=null) {
            return outstorageMapper.selectByExample(outstorageExample).get(0);
        }else {
            return null;
        }
    }

    @Override
    /**
     * 根据storage实体多条件查询
     */
    public List<Outstorage> findList(Outstorage entity) throws Exception {
        OutstorageExample outstorageExample =new OutstorageExample();
        OutstorageExample.Criteria criteria = outstorageExample.createCriteria();
//        // 材料名称
//        if (entity.getName()!=null)
//            criteria.andNameLike("%"+entity.getName()+"%");
//        //储存地点
//        if (entity.getStorageSite()!=null)
//            criteria.andStorageSiteLike("%"+entity.getStorageSite()+"%");
//        //储存方式
//        if (entity.getMode()!=null)
//            criteria.andModeLike("%"+entity.getMode()+"%");
//        //备注
//        if (entity.getRemark()!=null)
//            criteria.andRemarkLike("%"+entity.getRemark()+"%");
//        //负责人编号
//        if (entity.getIdCharge()!=null)
//            criteria.andIdChargeEqualTo(entity.getIdCharge());
//        //记录者编号
//        if (entity.getIdRecorder()!=null)
//            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        return outstorageMapper.selectByExample(outstorageExample);
    }

    public List<Outstorage> showAll() {
        OutstorageExample outstorageExample =new OutstorageExample();
        return outstorageMapper.selectByExample(outstorageExample);
    }



}