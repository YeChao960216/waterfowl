package cn.zhku.waterfowl.modules.manufacture.dao;

import org.apache.ibatis.annotations.Update;

/**
 * @Author： 成君 943193747@qq.com .
 * @Date： 2018/1/28 0028  15:11.
 */
public interface ManufactureDao {

    /**
     * 更改批次状态为加工阶段
     * @param idPacth
     */
    @Update("update patch set status = '30005' where id_poultry = #{idPacth}")
    void setPatchStatus(String idPacth);

    /**
     * 更改批次状态为待输阶段
     * @param idPacth
     */
    @Update("update patch set status = '30006' where id_poultry = #{idPacth}")
    int setPatchStatusToTrans(String idPacth);
}
