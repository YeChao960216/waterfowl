package cn.zhku.waterfowl.task;

import cn.zhku.waterfowl.modules.user.service.UserService;
import cn.zhku.waterfowl.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/10/22 10:54.
 * 说明：这是有关user的定时任务类
 */
@Service
//@EnableScheduling   // 开启定时任务
public class UserTask {

    @Autowired
    private UserService userService;    //  注入用户服务

    /**
     * 定时增加一个User记录
     */
    //@Scheduled(cron = "0 0 12,16 * * ?")  //    每天中午十二点和下午十六点触发任务
    public void addUserTask() {
        User user = new User(); //  生成实体类，并填充它
        user.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
        user.setUsername(String.valueOf(new Date()));
        user.setPassword("123456");
        user.setName("这是定时自动生成的用户");
        user.setDuty("这个用户是仅供测试的");
        user.setEntry(new Date());
        //  切接不能直接抛异常，要尽量捕捉异常并提供备用解决方法或提供信息
        try {
            userService.add(user);
        } catch (SQLException e) {
            System.out.println("sql错误");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
