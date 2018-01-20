package cn.zhku.waterfowl.modules.ddl.dao;

import cn.zhku.waterfowl.modules.ddl.model.DeathMethodVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Willon on 2018/1/19.
 */
public interface DDLDao {

    /**
     * 查找相同死法的水禽数量
     * @param idPatch  批次号
     * @return 死法和其对应总和的集合
     */
    @Select("SELECT   remark 'name',SUM(num_processed) 'value' FROM ddl WHERE id_patch = #{idPatch} GROUP BY remark")
    List<DeathMethodVo> findDeathMethod(@Param("idPatch") String idPatch);
}
