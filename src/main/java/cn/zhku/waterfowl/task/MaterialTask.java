package cn.zhku.waterfowl.task;

import cn.zhku.waterfowl.modules.aquaculture.dao.CheckQuantitydao;
import cn.zhku.waterfowl.modules.material.dao.MaterialDao;
import cn.zhku.waterfowl.modules.material.service.MaterialService;
import cn.zhku.waterfowl.pojo.entity.Material;
import cn.zhku.waterfowl.pojo.entity.MaterialExample;
import cn.zhku.waterfowl.pojo.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:叶超 yc755909707@foxmail.com
 * @version:create in 22:56 2017/11/27
 * @description:
 */
@Service
@EnableScheduling
public class MaterialTask {
    @Autowired
    private MaterialService materialService;
    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialDao materialDao;
    /**
     * 定时增加一个Material记录
     */
    @Scheduled(cron = "59 59 23 * * ?")  //    每天23时59分59秒触发任务
    public void addMaterialTask() {
        MaterialExample materialExample = new MaterialExample();
        List<Material> materialList = new ArrayList<Material>(materialMapper.selectByExample(materialExample));
        for (int i = 0; i < materialList.size(); i++) {
            Material material = materialList.get(i);//  生成实体类，并填充它
            Date t2 = materialList.get(i).getExpirationDate();
            Timestamp t1 = new Timestamp(System.currentTimeMillis());
            if (t2.before(t1)) {
                material.setType("已过期");
                materialDao.updateNum(material.getQuantity(),material.getName(),material.getAssociatedFirm(),material.getRemark());
            }
//        material.(String.valueOf(new Date()));
//        material.setPassword("123456");
//        material.setName("这是定时自动生成的用户");
//        material.setDuty("这个用户是仅供测试的");
            //  切接不能直接抛异常，要尽量捕捉异常并提供备用解决方法或提供信息
            try {
                materialMapper.updateByPrimaryKeySelective(material);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}