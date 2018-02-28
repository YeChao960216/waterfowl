package cn.zhku.waterfowl.modules.aquaculture.service;

import cn.zhku.waterfowl.modules.aquaculture.model.FeedWeight;
import cn.zhku.waterfowl.pojo.entity.Aquaculture;
import cn.zhku.waterfowl.pojo.entity.AquacultureExample;
import cn.zhku.waterfowl.pojo.mapper.AquacultureMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 成君
 * @date 21:43 2017/11/21 0021
 * @E-mail 943193747@qq.com
 */
@Service
public class AquacultureService  implements IBaseService<Aquaculture>{
    @Autowired
    private AquacultureMapper aquacultureMapper;


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
     *   根据IdPatch属性查找记录
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public Aquaculture get(Aquaculture entity) throws Exception {
        AquacultureExample aquacultureExample = new AquacultureExample();   //   多条件查询时使用的
        if (entity.getIdPatch() != null) {
            //   相当于where dipatch = entity.getIdPatch()
            aquacultureExample.or().andIdPatchEqualTo(entity.getIdPatch());
            //  使用get(0)的原因是Example参数的东西是集合，但我们只要一个符合条件的记录
            Aquaculture aquaculture = aquacultureMapper.selectByExample(aquacultureExample).get(0);
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

        if (entity.getIdPatch() != null)   // 如果IdBatch参数不为空，则查询时添加在sql上，
            //  相当于 where IdBatch like %entity.getIdBatch()%
            criteria.andIdPatchLike("%"+entity.getIdPatch()+"%");
        if (entity.getIdFowlery() != null)
            //  相当于 type = entity.getFowleryId()
            criteria.andIdFowleryLike("%"+entity.getIdFowlery()+"%");
        if (entity.getRecordDate() != null)
            //  相当于 duty = entity.getFowleryId()
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        if (entity.getStatus() != null)
            //  相当于 duty = entity.getStatus()
            criteria.andStatusEqualTo(entity.getStatus());
        if (entity.getName() != null)
            //  相当于 duty = entity.getName()
            criteria.andNameEqualTo(entity.getName());
        if (entity.getIdRecorder() != null)
            //  相当于 duty = entity.getIdRecorder()
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        if (entity.getIdCharge() != null)
            //  相当于 duty = entity.getIdCharge()
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        return aquacultureMapper.selectByExample(aquacultureExample);
    }

    /**
     *  查找重量
     * @param aquaculture 参数 neme , idPacth
     * @return FeedWeight
     * @throws Exception sql
     */
    public List<FeedWeight> showWeight(Aquaculture aquaculture) throws Exception {

        List<FeedWeight> feedWeightList = new ArrayList<>();


        String maxName = aquaculture.getName();

        //  消除name的影响
        aquaculture.setName(null);
        //  找出所有批次id相同的养殖记录
        List<Aquaculture> aquacultureList = findList(aquaculture);

        //  累加重量
        aquacultureList.forEach(
                aq -> {
                    //  如果name天数小于传进来的参数， 喂养重量相加
                    if (Integer.parseInt(aq.getName()) <= Integer.parseInt(maxName)){
                        FeedWeight feedWeight = new FeedWeight();

                        feedWeight.setFeedWeight( aq.getFeedWeight());
                        feedWeight.setName(aq.getName());
                        feedWeight.setWeight(aq.getWeight());

                        feedWeightList.add(feedWeight);
                    }


                }
        );
        return feedWeightList;
    }

}