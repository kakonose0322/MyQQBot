package com.zwp.myqqbot.service.impl;

import com.zwp.myqqbot.service.SearchWeartherService;
import com.zwp.myqqbot.utils.WindowsCmdUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwp
 * @create 2020-06-12 8:29
 */
@Service
public class SearchWeartherServerImpl implements SearchWeartherService {
    @Override
    public String searchWearther(String raw_message) {
        // 获得初始关键信息
        StringBuilder returnMsg = new StringBuilder();
        String e_mail = null;
        List<String> addrs = new ArrayList<>();
        // 判断输入的是中文字符还是英文字符
        if (raw_message.contains("，")) {
            e_mail = raw_message.substring(raw_message.indexOf("，"),raw_message.length());
        }else if (raw_message.contains(",")) {
            e_mail = raw_message.substring(raw_message.indexOf(","),raw_message.length());
        }else {
            return "请输入中文或英文逗号，不然我无法收到你的脑电波！";
        }
        if (e_mail.contains(",")) {
            String[] split = e_mail.split(",");
            for (String i:split) {
                addrs.add(i);
            }
        }else if(e_mail.contains("，")) {
            String[] split = e_mail.split("，");
            for (String i:split) {
                addrs.add(i);
            }
        }else {
            addrs.add(e_mail);
        }
        String res = WindowsCmdUtil.setupPython(addrs);
        if (res.equals("success")) {
            res = "今天的天气已经发送给您了，请注意查收！";
        }else {
            res = "系统发生不可名状的问题，您的消息被古神带走了！";
        }
        return res;
    }
}
