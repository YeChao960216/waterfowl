package com.zhku.test;




import cn.zhku.waterfowl.modules.user.service.UserService;
import cn.zhku.waterfowl.pojo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/18 20:40.
 * 说明：测试类模板
 */

@RunWith(SpringJUnit4ClassRunner.class)
//  引入配置文件
@ContextConfiguration("classpath*:spring/spring-*.xml")
public class CommonTest {
    private static Logger logger = LoggerFactory.getLogger(CommonTest.class);

    @Autowired
    UserService userService;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    @Test
    public void testUserList() throws Exception {
        logger.info("============ user ================ "+userService.findList(new User()));
    }

}
