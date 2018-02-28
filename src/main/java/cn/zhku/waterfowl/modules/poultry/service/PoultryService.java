package cn.zhku.waterfowl.modules.poultry.service;

import cn.zhku.waterfowl.modules.poultry.dao.PoultryDao;
import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.pojo.entity.PoultryExample;
import cn.zhku.waterfowl.pojo.mapper.PoultryMapper;
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
public class PoultryService  implements IBaseService<Poultry> {

    @Autowired
    private PoultryMapper poultryMapper;
    @Autowired
    private PoultryDao poultryDao;
    /**
     * 对某个实体对象（相对应的表）添加操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int add(Poultry entity) throws Exception {
        return poultryMapper.insert(entity);
    }

    /**
     * 对某个实体对象（相对应的表）修改操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int update(Poultry entity) throws Exception {
        return poultryMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 对某个实体对象（相对应的表）删除操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int delete(Poultry entity) throws Exception {
        return poultryMapper.deleteByPrimaryKey(entity.getIdPoultry());
    }

    /**
     * 通过ID获取某个对象实体
     *
     * @param id 主键ID
     * @return 实体
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public Poultry get(String id) throws Exception {
        return poultryMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过设置实体某些字获取个实体对象（相对应的表）
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public Poultry get(Poultry entity) throws Exception {
        PoultryExample poultryExample =new PoultryExample();
        poultryExample.or().andIdPoultryEqualTo(entity.getIdPoultry());
        if (poultryExample!=null) {
            return poultryMapper.selectByExample(poultryExample).get(0);
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
    public List<Poultry> findList(Poultry entity) throws Exception {
        PoultryExample poultryExample = new PoultryExample();
        PoultryExample.Criteria criteria = poultryExample.createCriteria();
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
            criteria.andTypeLike("%"+entity.getType()+"%");
        if (entity.getIdPoultry()!=null)
            criteria.andIdPoultryEqualTo("%"+entity.getIdPoultry()+"%");
        //负责人编号
        if (entity.getIdCharge()!=null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        //种苗信息查找
        if (entity.getIdGermchit()!=null)
            criteria.andIdGermchitEqualTo(entity.getIdGermchit());
        //记录者编号
        if (entity.getIdRecorder()!=null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        return poultryMapper.selectByExample(poultryExample);
    }
    public List<Poultry> showAll(Poultry entity, CommonQo commonQo) {
        PoultryExample poultryExample = new PoultryExample();
        PoultryExample.Criteria criteria = poultryExample.createCriteria();
        //  根据入厂时间区间来查找
        if (commonQo.getStart() != null)
            criteria.andRecordDateGreaterThanOrEqualTo(commonQo.getStart());
        if (commonQo.getEnd() != null)
            criteria.andRecordDateLessThanOrEqualTo(commonQo.getEnd());
        return poultryMapper.selectByExample(poultryExample);
    }
//    /**
//     *  多条件查询类
//     * @param entity    实体类的各个属性
//     * @param commonQo  通用查询类
//     * @return  材料列表
//     * @throws Exception   抛出参数错误、SQL操作等异常
//     */
//    public List<Material> list(Material entity, CommonQo commonQo) throws Exception{
//        MaterialExample materialExample = new MaterialExample();
//        MaterialExample.Criteria criteria = materialExample.createCriteria();
//        //  根据时间区间来查找
//        if (commonQo.getStart() != null)
//            criteria.andDateGreaterThanOrEqualTo(commonQo.getStart());
//        if (commonQo.getEnd() != null)
//            criteria.andDateLessThanOrEqualTo(commonQo.getEnd());
//            return materialMapper.selectByExample(materialExample);
//    }


}
