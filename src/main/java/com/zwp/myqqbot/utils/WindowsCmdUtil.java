package com.zwp.myqqbot.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zwp
 * @create 2020-06-12 8:21
 * @deprecated Java执行Windows脚本文件
 */
public class WindowsCmdUtil {
    public static String setupPython(List<String> addr) {
        // 基础命令
        String exce = "python  E:\\PyChramProject\\PyTest\\SendTQ\\SendTQByText.py";
        try {
            if (addr.size() <= 1) {
                Process proc = Runtime.getRuntime().exec(exce + "  " +addr.get(0));
                proc.waitFor();
            }else {
                // list快速转数组的方式
//                String[] strings = new String[addr.size()];
//                addr.toArray(strings);
                for (String i:addr){
                    exce += ("  " + i);
                }
                Process proc = Runtime.getRuntime().exec(exce);
                proc.waitFor();
            }
        }catch (Exception e) {
            System.out.println("执行失败！");
        }
        return "success";
    }

    public static void main(String[] args) {
        List<String> addr = new ArrayList<>();
        addr.add("kakonose@163.com");
//        addr.add("3072994091@qq.com");
        String s = WindowsCmdUtil.setupPython(addr);
        System.out.println(s);
    }
}
