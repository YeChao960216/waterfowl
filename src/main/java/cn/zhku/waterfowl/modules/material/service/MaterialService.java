package cn.zhku.waterfowl.modules.material.service;

import cn.zhku.waterfowl.pojo.entity.Material;
import cn.zhku.waterfowl.pojo.entity.MaterialExample;
import cn.zhku.waterfowl.pojo.mapper.MaterialMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import cn.zhku.waterfowl.util.modle.CommonQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/14 18:24.
 * 说明： 材料表服务
 */
@Service
public class MaterialService  implements IBaseService<Material>{

    @Autowired
    private MaterialMapper materialMapper;

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
        return materialMapper.deleteByPrimaryKey(entity.getIdMaterial());
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
        return null;
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
       return null;
    }

    /**
     *  多条件查询类
     * @param entity    实体类的各个属性
     * @param commonQo  通用查询类
     * @return  材料列表
     * @throws Exception   抛出参数错误、SQL操作等异常
     */
    public List<Material> list(Material entity, CommonQo commonQo) throws Exception{
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();

        //  根据时间区间来查找
        if (commonQo.getStart() != null)
            criteria.andDateLessThanOrEqualTo(commonQo.getStart());
        if (commonQo.getEnd() != null)
            criteria.andDateGreaterThanOrEqualTo(commonQo.getEnd());
            return materialMapper.selectByExample(materialExample);
    }


}
