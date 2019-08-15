package com.mango.test;

import com.mango.service.ClazzService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void testrun1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-conf/applicationContext.xml");
        // 获取对象
        ClazzService as = (ClazzService) ac.getBean("clazzServiceImpl");
        // 调用方法
        as.selectAll();
    }

}
