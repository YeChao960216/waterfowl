package cn.zhku.waterfowl.modules.epidemic.dao;

import org.apache.ibatis.annotations.Update;


public interface EpidemicDao {
    /**
     *  更新状态为已提交
     * @param id
     * @return
     */
    @Update("update epidemic set flag=1 where id_epidemic = #{id}")
    int updateFlagById(String id);
}
