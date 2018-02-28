package cn.zhku.waterfowl.modules.outPoultry.servie;

import cn.zhku.waterfowl.modules.patch.dao.PatchDao;
import cn.zhku.waterfowl.pojo.entity.OutPoultry;
import cn.zhku.waterfowl.pojo.entity.OutPoultryExample;
import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.mapper.OutPoultryMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutPoultryService implements IBaseService<OutPoultry>{
    @Autowired
    private OutPoultryMapper outPoultryMapper;
    @Autowired
    private PatchDao patchDao;

    /**
     * 增加记录
     * @param entity
     * @return 状态码 1 成功， 0 失败
     * @throws Exception
     */
    @Override
    public int add(OutPoultry entity) throws Exception {
        System.out.println(entity.getIdCharge());
        return outPoultryMapper.insert(entity);
    }

    /**
     * 修改记录
     * @param entity
     * @return 状态码 1 成功， 0 失败
     * @throws Exception
     */
    @Override
    public int update(OutPoultry entity) throws Exception {
        return outPoultryMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     *  根据主键删除记录
     * @param entity
     *            映射数据库单表的实体类
     * @return 状态码 1 成功， 0 失败
     * @throws Exception
     */
    @Override
    public int delete(OutPoultry entity) throws Exception {
        return outPoultryMapper.deleteByPrimaryKey(entity.getId());
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public OutPoultry get(String id) throws Exception {
        return outPoultryMapper.selectByPrimaryKey(id);
    }

    /**
     *   根据IdPatch属性查找记录
     * @param entity
     *            映射数据库单表的实体类
     * @return
     * @throws Exception
     */
    @Override
    public OutPoultry get(OutPoultry entity) throws Exception {
        OutPoultryExample outPoultryExample = new OutPoultryExample();
        if (entity.getIdPatch() != null) {
            outPoultryExample.or().andIdPatchEqualTo(entity.getIdPatch());
            OutPoultry outPoultry = outPoultryMapper.selectByExample(outPoultryExample).get(0);
            return outPoultry;
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
    public List<OutPoultry> findList(OutPoultry entity) throws Exception {
        OutPoultryExample outPoultryExample = new OutPoultryExample();
        OutPoultryExample.Criteria criteria = outPoultryExample.createCriteria();
        if (entity.getStatus() != null)
            criteria.andStatusEqualTo(entity.getStatus());
        if (entity.getIdPatch() != null)
            criteria.andIdPatchLike("%"+entity.getIdPatch()+"%");
        if (entity.getFirm() != null)
            criteria.andFirmLike("%"+entity.getFirm()+"%");
        if (entity.getRecordDate() != null)
            criteria.andRecordDateEqualTo(entity.getRecordDate());
        if (entity.getIdRecord() != null)
            criteria.andIdRecordEqualTo(entity.getIdRecord());
        if (entity.getIdCharge() != null)
            criteria.andIdChargeEqualTo(entity.getIdCharge());

        return outPoultryMapper.selectByExample(outPoultryExample);
    }

    public List<String> findOutpoultry(String id_poultry) throws Exception {
        //把listOutstorageByName返回的值放在ArrayList里面
        return patchDao.findOutpoultry(id_poultry);
    }

}
