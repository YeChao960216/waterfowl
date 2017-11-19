package cn.zhku.waterfowl.modules.poultry.service;

import cn.zhku.waterfowl.pojo.entity.Poultry;
import cn.zhku.waterfowl.pojo.entity.PoultryExample;
import cn.zhku.waterfowl.pojo.mapper.PoultryMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import cn.zhku.waterfowl.util.modle.CommonQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/14 18:22.
 * 说明：水禽表的服务
 */

@Service
public class PoultryService implements IBaseService<Poultry>{

    @Autowired
    private PoultryMapper poultryMapper;

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
        return null;
    }

    /** 暂时不用
     * 通过查询条件获取某个实体对象（相对应的表）列表操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public List<Poultry> findList(Poultry entity) throws Exception {
        return null;
    }

    /**
     *  多条件查询
     * @param entity    实体类
     * @param commonQo  通用查询类
     * @return  List<Poultry>
     */
    public List<Poultry> list(Poultry entity, CommonQo commonQo) {
        PoultryExample poultryExample = new PoultryExample();
        PoultryExample.Criteria criteria = poultryExample.createCriteria();

        //  根据时间区间来查找
        if (commonQo.getStart() != null)
            criteria.andRecordDateGreaterThanOrEqualTo(commonQo.getStart());
        if (commonQo.getEnd() != null)
            criteria.andRecordDateLessThanOrEqualTo(commonQo.getEnd());
        return poultryMapper.selectByExample(poultryExample);
    }
}
