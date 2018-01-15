package cn.zhku.waterfowl.modules.material.service;

import cn.zhku.waterfowl.modules.material.dao.MaterialDao;
import cn.zhku.waterfowl.modules.outStorage.dao.OutStorageDao;
import cn.zhku.waterfowl.pojo.entity.Material;
import cn.zhku.waterfowl.pojo.entity.MaterialExample;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.mapper.MaterialMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import cn.zhku.waterfowl.util.modle.CommonQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 叶超 yc755909707@foxmail.com
 * @version : 2017/11/14 18:24.
 * 说明： 物资表服务
 */
@Service
public class MaterialService  implements IBaseService<Material>{

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialDao materialDao;
    /**
     * 对某个实体对象（相对应的表）添加操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int add(Material entity) throws Exception {
        return materialMapper.insert(entity);
    }

    /**
     * 对某个实体对象（相对应的表）修改操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int update(Material entity) throws Exception {
        return materialMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 对某个实体对象（相对应的表）删除操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int delete(Material entity) throws Exception {
        return materialMapper.deleteByPrimaryKey(entity.getIdStorage());
    }

    /**
     * 通过ID获取某个对象实体
     *
     * @param id 主键ID
     * @return 实体
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public Material get(String id) throws Exception {
        return materialMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过设置实体某些字获取个实体对象（相对应的表）
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public Material get(Material entity) throws Exception {
        MaterialExample materialExample =new MaterialExample();
        materialExample.or().andIdStorageEqualTo(entity.getIdStorage());
        if (materialExample!=null) {
            return materialMapper.selectByExample(materialExample).get(0);
        }else {
            return null;
        }
    }

    /**
     * 通过查询条件获取某个实体对象（相对应的表）列表操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public List<Material> findList(Material entity) throws Exception {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        // 物资名称
        if (entity.getName()!=null)
            criteria.andNameLike("%"+entity.getName()+"%");
        // 关联厂商名称
        if (entity.getAssociatedFirm()!=null)
            criteria.andAssociatedFirmLike("%"+entity.getAssociatedFirm()+"%");
        // 联系电话
        if (entity.getPhone()!=null)
            criteria.andPhoneLike("%"+entity.getPhone()+"%");
        //生产厂家
        if (entity.getRemark()!=null)
            criteria.andRemarkLike("%"+entity.getRemark()+"%");
        //物资类型
        if (entity.getType()!=null)
            criteria.andTypeEqualTo(entity.getType());
        //物资类型
        if (entity.getStorageSite()!=null)
            criteria.andStorageSiteLike("%"+entity.getStorageSite()+"%");
        //物资类型
        if (entity.getMode()!=null)
            criteria.andModeLike("%"+entity.getMode()+"%");
//        //库存编号
        if (entity.getIdStorage()!=null)
            criteria.andIdStorageEqualTo("%"+entity.getIdStorage()+"%");
////        //备注
////        if (entity.getRemark()!=null)
////            criteria.andRemarkLike("%"+entity.getRemark()+"%");
        //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //记录者编号
        if (entity.getIdRecorder()!=null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        return materialMapper.selectByExample(materialExample);
    }
    public List<Material> showAll(Material entity, CommonQo commonQo) {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        //  根据入厂时间区间来查找
        if (commonQo.getStart() != null)
            criteria.andDateGreaterThanOrEqualTo(commonQo.getStart());
        if (commonQo.getEnd() != null)
            criteria.andDateLessThanOrEqualTo(commonQo.getEnd());
        return materialMapper.selectByExample(materialExample);
    }
    public void updateOutstroge(float quantity,String name,String remark,String type) {
        materialDao.updateQuantity(quantity,name,remark,type);
    }

    public String listOutstorageid(String name, String remark)throws Exception {
       return materialDao.listOutstorageid(name,remark);
    }

}
