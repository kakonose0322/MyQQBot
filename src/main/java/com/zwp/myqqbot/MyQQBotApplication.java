package com.zwp.myqqbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zwp
 * @create 2020-05-28 9:10
 */
@SpringBootApplication
//@EnableScheduling // 开启定时任务
public class MyQQBotApplication {
    public static void main(String[] args) {
//        ServiceUtil.startMysql();
//        ServiceUtil.startRedis();
        SpringApplication.run(MyQQBotApplication.class, args);
    }
}
