package cn.zhku.waterfowl.modules.ddl.service;

import cn.zhku.waterfowl.pojo.entity.Ddl;
import cn.zhku.waterfowl.pojo.entity.DdlExample;
import cn.zhku.waterfowl.pojo.mapper.DdlMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DdlService implements IBaseService<Ddl> {
    private final DdlMapper ddlMapper;

    @Autowired
    public DdlService(DdlMapper ddlMapper) {
        this.ddlMapper = ddlMapper;
    }

    /**
     * 通过ID获取某个对象实体
     *
     * @param id 主键ID
     * @return Ddl类型实体
     * @throws Exception
     */
    @Override
    public Ddl get(String id) throws Exception {
        return ddlMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过设置实体某些字获取个实体对象（相对应的表）
     *
     * @param entity 映射数据库单表的实体类
     * @return Ddl类型实体
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public Ddl get(Ddl entity) throws Exception {
        return ddlMapper.selectByPrimaryKey(entity.getId());
    }


    /**
     * 对某个实体对象（相对应的表）添加操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int add(Ddl entity) {
        try {
            ddlMapper.insertSelective(entity);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    /**
     * 对某个实体对象（相对应的表）修改操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 状态参数  1表示修改成功 0表示修改失败
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int update(Ddl entity) throws Exception {
        if (checkFlag(entity) == 0) {
            ddlMapper.updateByPrimaryKeySelective(entity);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 对某个实体对象（相对应的表）删除操作
     *
     * @param entity 映射数据库单表的实体类
     * @return 状态参数  1表示修改成功 0表示修改失败
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int delete(Ddl entity) throws Exception {
        if (checkFlag(entity) == 0) {
            ddlMapper.deleteByPrimaryKey(entity.getId());
            return 1;
        } else return 0;
    }

    /**
     * 通过查询条件获取某个实体对象（相对应的表）列表操作
     *
     * @param entity 映射数据库单表的实体类
     * @return List<Ddl>
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public List<Ddl> findList(Ddl entity) throws Exception {
        DdlExample ddlExample = new DdlExample();
        DdlExample.Criteria criteria = ddlExample.createCriteria();
        if (entity.getIdCharge() != null&&entity.getIdCharge().trim()!="")
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        if (entity.getIdPoultry() != null&&entity.getIdPoultry().trim()!="")
            criteria.andIdPoultryEqualTo(entity.getIdPoultry());
        if (entity.getIdRecorder() != null&&entity.getIdRecorder().trim()!="")
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        if (entity.getFlag() != null)
            criteria.andFlagEqualTo(entity.getFlag());
        if (entity.getNumProcessed()!= null)
            criteria.andNumProcessedEqualTo(entity.getNumProcessed());
        if (entity.getRecordDate()!= null)
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        if (entity.getRemark() != null&&entity.getRemark().trim()!="")
            criteria.andRemarkLike("%" + entity.getRemark() + "%");
        if (entity.getProcessingMode() != null&&entity.getProcessingMode().trim()!="")
            criteria.andProcessingModeLike("%" + entity.getProcessingMode() + "%");
        return ddlMapper.selectByExample(ddlExample);
    }

    /**
    *检查提交状态
    * 其中1为已经提交, 0为未提交
    * */
    private int checkFlag(Ddl entity) {

        Ddl ddl = null;
        try {
            ddl = get(entity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("该实体不存在");
        }
        if (ddl.getFlag() == 1) {
            return 1;
        } else return 0;
    }

    public List<Ddl> showAllByFlag(int flag) {
        DdlExample ddlExample = new DdlExample();
        DdlExample.Criteria criteria = ddlExample.createCriteria();
        criteria.andFlagEqualTo(flag);
        return ddlMapper.selectByExample(ddlExample);
    }
 /**
 * 根据id修改提交状态为已经提交
 *
  * @param idList*/
    public int updateFlag(String[] idList) {
        Ddl ddl = new Ddl();
        System.out.println(idList[0]);
        try {
            for (String id : idList
                    ) {
                ddl.setId(id);
                ddl.setFlag(1);
                if ( update(ddl)==1){
                   System.out.println(ddl);
                }else { return 0;
                }
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
