package cn.zhku.waterfowl.modules.storage.service;
import cn.zhku.waterfowl.modules.storage.dao.StorageDao;
import cn.zhku.waterfowl.pojo.entity.Storage;
import cn.zhku.waterfowl.pojo.entity.StorageExample;
import cn.zhku.waterfowl.pojo.mapper.StorageMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StorageService  implements IBaseService<Storage>  {
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private StorageDao storageDao;
    @Override
    /**
     * 根据storage实体插入
     */
    public int add(Storage entity) throws Exception {
        return storageMapper.insert(entity);
    }

    @Override
    /**
     * 根据storage实体更新
     * @param entity 映射数据库单表的实体类
     * @return
     */
    public int update(Storage entity) throws Exception {
       return storageMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    /**
     *根据storage实体类id删除
     * @param entity 映射数据库单表的实体类
     * @return
     */
    public int delete(Storage entity) throws Exception {

            return storageMapper.deleteByPrimaryKey(entity.getIdStorage());

    }

    @Override
    /**
     * 根据id得到epdemic实体类
     */
    public Storage get(String idStorage) throws Exception {
        return storageMapper.selectByPrimaryKey(idStorage);
    }

    @Override
    /**
     * 根据epdemic实体类的id查询
     */
    public Storage get(Storage entity) throws Exception {
        StorageExample storageExample =new StorageExample();
        storageExample.or().andIdStorageEqualTo(entity.getIdStorage());
        if (storageExample!=null) {
            return storageMapper.selectByExample(storageExample).get(0);
        }else {
            return null;
        }
    }

    @Override
    /**
     * 根据storage实体多条件查询
     */
    public List<Storage> findList(Storage entity) throws Exception {
        StorageExample storageExample =new StorageExample();
        StorageExample.Criteria criteria = storageExample.createCriteria();
        // 材料名称
        if (entity.getName()!=null)
            criteria.andNameLike("%"+entity.getName()+"%");
        //储存地点
        if (entity.getStorageSite()!=null)
            criteria.andStorageSiteLike("%"+entity.getStorageSite()+"%");
        //储存方式
        if (entity.getMode()!=null)
            criteria.andModeLike("%"+entity.getMode()+"%");
        //备注
        if (entity.getRemark()!=null)
            criteria.andRemarkLike("%"+entity.getRemark()+"%");
        //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //记录者编号
        if (entity.getIdRecorder()!=null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        return storageMapper.selectByExample(storageExample);
    }

    public List<Storage> showAll() {
        StorageExample storageExample =new StorageExample();
        return storageMapper.selectByExample(storageExample);
    }


}