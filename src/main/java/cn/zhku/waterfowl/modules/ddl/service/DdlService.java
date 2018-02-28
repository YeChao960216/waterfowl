package cn.zhku.waterfowl.modules.ddl.service;
import cn.zhku.waterfowl.pojo.entity.Ddl;
import cn.zhku.waterfowl.pojo.entity.DdlExample;
import cn.zhku.waterfowl.pojo.entity.Patch;
import cn.zhku.waterfowl.pojo.mapper.DdlMapper;
import cn.zhku.waterfowl.pojo.mapper.PatchMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DdlService implements IBaseService<Ddl> {
    private final PatchMapper patchMapper;
    private final DdlMapper ddlMapper;
    @Autowired
    public DdlService(PatchMapper patchMapper, DdlMapper ddlMapper) {
        this.patchMapper = patchMapper;
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
     * 在添加死淘表时 会根据死淘表填写的numProcessed(死淘个体数)动态更新patch表的numtotal数目
     *
     * @param entity 映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception 抛出参数错误、SQL操作等异常
     */
    @Override
    public int add(Ddl entity) {
        int numProcessed = entity.getNumProcessed();
        String idPatch = entity.getIdPatch();
        try {
            Patch patch = patchMapper.selectByPrimaryKey(idPatch);
            System.out.println("jvlsdghdwjghdffgjkl"+patch);
            int size = patch.getSize();
            size-=numProcessed;
            patch.setSize(size);
            //  必须只更改size这一属性
            patchMapper.updateByPrimaryKeySelective(patch);
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
        int LnumProcessed = ddlMapper.selectByPrimaryKey(entity.getId()).getNumProcessed();//更新前死淘数目
        int NnumProcessed = entity.getNumProcessed();//当前死淘数目
        String idPatch = entity.getIdPatch();
        try {
            Patch patch = patchMapper.selectByPrimaryKey(idPatch);
            int numTotal = patch.getNumTotal();
            numTotal = numTotal+LnumProcessed-NnumProcessed;;
            patch.setNumTotal(numTotal);
            patchMapper.updateByPrimaryKey(patch);
            ddlMapper.updateByPrimaryKeySelective(entity);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
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
        int numProcessed = entity.getNumProcessed();
        String idPatch = entity.getIdPatch();
        try {
            Patch patch = patchMapper.selectByPrimaryKey(idPatch);
            int numTotal = patch.getNumTotal();
            numTotal += numProcessed;
            patch.setNumTotal(numTotal);
            patchMapper.updateByPrimaryKey(patch);
            ddlMapper.deleteByPrimaryKey(entity.getId());
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

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
        if (entity.getIdCharge() != null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());
        if (entity.getIdPatch() != null)
            criteria.andIdPatchEqualTo(entity.getIdPatch());
        if (entity.getIdRecorder() != null)
            criteria.andIdRecorderEqualTo(entity.getIdRecorder());
        if (entity.getNumProcessed()!= null)
            criteria.andNumProcessedEqualTo(entity.getNumProcessed());
        if (entity.getRecordDate()!=null)
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        if (entity.getRemark() != null)
            criteria.andRemarkLike("%" + entity.getRemark() + "%");
        if (entity.getProcessingMode() != null)
            criteria.andProcessingModeLike("%" + entity.getProcessingMode() + "%");
        //id
        if(entity.getId()!=null)
            criteria.andIdEqualTo(entity.getId());
        return ddlMapper.selectByExample(ddlExample);
    }
}
