package cn.zhku.waterfowl.modules.transportation.service;

import cn.zhku.waterfowl.modules.transportation.util.DbUtil;
import cn.zhku.waterfowl.pojo.entity.*;
import cn.zhku.waterfowl.pojo.mapper.ManufactureMapper;
import cn.zhku.waterfowl.pojo.mapper.TranscompanyMapper;
import cn.zhku.waterfowl.pojo.mapper.TransportationMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author 成君
 * @date  2018/1/24 2018/1/23 0022.
 * @E-mail 943193747@qq.com
 */

@Service
public class TransportationService {
    @Autowired
    TransportationMapper transportationMapper;

    /**
     * 增加记录
     * @param transportation
     * @return
     */
    public int add(Transportation transportation) {
        return transportationMapper.insert(transportation);
    }

    /**
     * 根据主键删除记录
     * @param transportation
     * @return 状态码 1 成功， 0 失败
     */
    public int delete(Transportation transportation) {
        return transportationMapper.deleteByPrimaryKey(transportation.getId());
    }

    /**
     * 修改
     * @param transportation
     * @return
     */
    public int update(Transportation transportation) {
        return transportationMapper.updateByPrimaryKeySelective(transportation);
    }

    /**
     * 根据主键返回 transportation
     * @param id
     * @return
     */
    public Transportation get(String id) {
        return transportationMapper.selectByPrimaryKey(id);
    }

    /**
     * 处理多条件查询
     * @param transportation
     * @return
     */
    public List<Transportation> findList(Transportation transportation) {
        TransportationExample transportationExample = new TransportationExample();

        TransportationExample.Criteria criteria = transportationExample.createCriteria();

        if (StringUtils.isNotBlank(transportation.getIdPatch()))   // 批次
            criteria.andIdPatchLike("%"+transportation.getIdPatch()+"%");
        if (StringUtils.isNotBlank(transportation.getTid()))  // 运输厂商id
            criteria.andTidEqualTo(transportation.getTid());
        if (StringUtils.isNotBlank(transportation.getCid()))  // 顾客id
            criteria.andCidEqualTo(transportation.getCid());
        if (transportation.getCurdate()!=null)  // 当前日期
            criteria.andCurdateEqualTo(transportation.getCurdate());
        if (StringUtils.isNotBlank(transportation.getDriver() )) //  司机
            criteria.andDriverLike("%"+transportation.getDriver()+"%");
        if (StringUtils.isNotBlank(transportation.getPhone() )) //  司机电话
            criteria.andPhoneLike("%"+transportation.getPhone()+"%");
        return transportationMapper.selectByExample(transportationExample);
    }

    public boolean isArrival(Connection con,String id,float lng,float lat)throws Exception{
            con = DbUtil.getCon();
            ResultSet rs = getLngAndLatDao(con,id);
            System.out.print("=============");
            float rLng = rs.getFloat("lng");
            float rLat = rs.getFloat("lat");
            System.out.print("经度======"+rLng+"纬度========="+rLat);
            if (lng==rLng&&lat==rLat) {
                return true;
            }else {
                return false;
            }
    }

    /**
     * 获取顾客的地址的经纬度
     * @param con
     * @param id
     * @return 经度lng，纬度lat
     * @throws Exception
     */
    private ResultSet getLngAndLatDao(Connection con, String id) throws Exception{

        String sql = "select lng,lat from customer where cid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        return ps.executeQuery();

    }
}
