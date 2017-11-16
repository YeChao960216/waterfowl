package cn.zhku.waterfowl.modules.aquaculture.service;

import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.AquacultureExample;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.mapper.AquacultureMapper;
import cn.zhku.waterfowl.pojo.mapper.OutstorageMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AquacultureService  implements IBaseService<Aquaculture>{
    @Autowired
    private AquacultureMapper aquacultureMapper;

    @Autowired
    private OutstorageMapper outstorageMapper;

    /**
     * 增加记录
     * @param entity
     * @return 状态码 1 成功， 0 失败
     * @throws Exception
     */
    @Override
    public int add(Aquaculture entity) throws Exception {
        return aquacultureMapper.insert(entity);
    }

    /**
     * 修改记录
     * @param entity
     * @return 状态码 1 成功， 0 失败
     * @throws Exception
     */
    @Override
    public int update(Aquaculture entity) throws Exception {
        //  注意：Selective的意思是，如果实体类属性不为空就修改，所以不会出现空值属性覆盖数据库记录
        return aquacultureMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     *  根据主键删除记录
     * @param entity
     *            映射数据库单表的实体类
     * @return 状态码 1 成功， 0 失败
     * @throws Exception
     */
    @Override
    public int delete(Aquaculture entity) throws Exception {
        return aquacultureMapper.deleteByPrimaryKey(entity.getId());
    }

    /**
     * 根据主键返回 aquaculture
     * @param id
     * @return aquaculture
     * @throws Exception
     */
    @Override
    public Aquaculture get(String id) throws Exception {
        return aquacultureMapper.selectByPrimaryKey(id);
    }

    /**
     *   根据IdBatch属性查找记录
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public Aquaculture get(Aquaculture entity) throws Exception {
        AquacultureExample aquacultureExample = new AquacultureExample();   //   多条件查询时使用的
        if (entity.getIdPoultry() != null) {
            //   相当于where username = entity.getUsername()
            aquacultureExample.or().andIdPoultryEqualTo(entity.getIdPoultry());
            //  使用get(0)的原因是Example参数的东西是集合，但我们只要一个符合条件的记录
            Aquaculture aquaculture = aquacultureMapper.selectByExample(aquacultureExample).get(0);
//           AquacultureVo aquacultureVo = new AquacultureVo();
//           aquacultureVo.setAquaculture(aquaculture);
//
//            Outstorage outstorage = outstorageMapper.selectByPrimaryKey("1");
//            aquacultureVo.setOutstorage(outstorage);

            return aquaculture;
        } else {
            return null;
        }
    }

    /**
     *  处理多条件查询
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public List<Aquaculture> findList(Aquaculture entity) throws Exception {
        //  Example相当储放条件的地方，where xxx = xxxx and ccc =ccc
        AquacultureExample aquacultureExample = new AquacultureExample();
        //  Criteria是Example的静态子类，里面有条件的jva代码表达方式
        AquacultureExample.Criteria criteria = aquacultureExample.createCriteria();

        if (entity.getIdPoultry() != null)   // 如果IdBatch参数不为空，则查询时添加在sql上，
            //  相当于 where IdBatch like %entity.getIdBatch()%
            criteria.andIdPoultryLike("%"+entity.getIdPoultry()+"%");
        if (entity.getIdFowlery() != null)
            //  相当于 type = entity.getFowleryId()
            criteria.andIdFowleryLike("%"+entity.getIdFowlery()+"%");
        if (entity.getRecordDate() != null)
            //  相当于 duty = entity.getFowleryId()
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        if (entity.getIdRecorder() != null)
            //  相当于 duty = entity.getIdRecorder()
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        if (entity.getIdCharge() != null)
            //  相当于 duty = entity.getIdCharge()
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        if (entity.getType() != null)
            //  相当于 duty = entity.getType()
            criteria.andTypeLike("%"+entity.getType()+"%");


        return aquacultureMapper.selectByExample(aquacultureExample);
    }



}