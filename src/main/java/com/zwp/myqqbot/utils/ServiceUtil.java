package com.zwp.myqqbot.utils;

import com.zwp.myqqbot.constant.ServiceConst;
import java.io.IOException;

/**
 * @author zwp
 * @create 2020-05-28 10:23
 * @deprecated 服务工具类，用以启动mysql服务与redis服务
 */
public class ServiceUtil {
    public static void startMysql() {
        String command = "net start mysql";
        try {
            Process p = Runtime.getRuntime().exec(command);
            System.out.println("----------mysql服务启动成功----------");
        } catch (IOException e) {
            System.out.println("----------mysql服务启动失败----------");
            e.printStackTrace();
        }
    }

    public static void startRedis() {
        String command = ServiceConst.REDIS_BAT_PATH + " " + ServiceConst.REDIS_INSTALL_PATH;
        try {
            Process p = Runtime.getRuntime().exec(command);
            System.out.println("----------redis服务启动成功----------");
        } catch (IOException e) {
            System.out.println("----------redis服务启动失败----------");
            e.printStackTrace();
        }
    }
}
