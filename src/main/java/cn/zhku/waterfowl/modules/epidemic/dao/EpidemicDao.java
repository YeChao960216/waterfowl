package cn.zhku.waterfowl.modules.epidemic.dao;

import cn.zhku.waterfowl.modules.epidemic.model.DiseaesMethodVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by gonefuture on 2018/1/19.
 */
public interface EpidemicDao {

    /**
     * 查找相同死法的水禽数量
     * @param idPatch  批次号
     * @return 死法和其对应总和的集合
     */
    @Select("SELECT   diseaes 'name',SUM(num_infected) 'value' FROM epidemic WHERE id_patch =  #{idPatch} GROUP BY diseaes")
    List<DiseaesMethodVo> findDiseaesMethod(@Param("idPatch") String idPatch);
}
