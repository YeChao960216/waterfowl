package cn.zhku.waterfowl.task;

import cn.zhku.waterfowl.pojo.entity.Outstorage;
import cn.zhku.waterfowl.pojo.entity.OutstorageExample;
import cn.zhku.waterfowl.pojo.mapper.OutstorageMapper;
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
    private OutstorageMapper outstorageMapper;
    /**
     * 定时增加一个Material记录
     */
    @Scheduled(cron = "1 0 0 * * ?")  //    每天0时0分1秒触发任务
    public void addMaterialTask() {
        OutstorageExample outstorageExample = new OutstorageExample();
        List<Outstorage> outstorageList = new ArrayList<Outstorage>(outstorageMapper.selectByExample(outstorageExample));
        for (int i = 0; i < outstorageList.size(); i++) {
            Outstorage outstorage = outstorageList.get(i);//  生成实体类，并填充它
            Date t2 = outstorageList.get(i).getExpirationDate();
            Timestamp t1 = new Timestamp(System.currentTimeMillis());
            if (t2.before(t1)) {
                outstorage.setValid("已过期");
            //  切接不能直接抛异常，要尽量捕捉异常并提供备用解决方法或提供信息
            try {
                outstorageMapper.updateByPrimaryKeySelective(outstorage);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }}
            }}
        }