package com.zwp.myqqbot.service.impl;

import com.google.gson.Gson;
import com.zwp.myqqbot.entity.BotResponse;
import com.zwp.myqqbot.entity.SFBot;
import com.zwp.myqqbot.service.ChatServer;
import com.zwp.myqqbot.utils.HttpClientUtil;
import org.springframework.stereotype.Service;

/**
 * @author zwp
 * @create 2020-06-01 16:24
 */
@Service
public class ChatServerImpl implements ChatServer {
    @Override
    public String chatBot(String raw_message) {
        // 获得初始关键信息
        StringBuilder returnMsg = new StringBuilder();
        String question = null;
        BotResponse botResponse = new BotResponse();
        // 切割获得问题,method1
//        String question = raw_message.split("\\,")[1];
        // 切割获得问题,method2
        // 判断输入的是中文字符还是英文字符
        if (raw_message.contains("，")) {
            question = raw_message.substring(raw_message.indexOf("，"),raw_message.length());
        }else if (raw_message.contains(",")) {
            question = raw_message.substring(raw_message.indexOf(","),raw_message.length());
        }else {
            return "请输入中文或英文逗号，不然我无法收到你的脑电波！";
        }
        // 封装请求信息
        SFBot bot = new SFBot();
        bot.setAppid("your id");
        bot.setUserid("your account");
        bot.setSpoken(question);
//        System.out.println(question);
        /*转换json*/
        Gson gson = new Gson();
        String data = gson.toJson(bot);
//        System.out.println(myMessageJson);
        String url = "https://api.ownthink.com/bot";
        // 请求聊天链接
        String s = HttpClientUtil.doPost(url, data, "UTF-8");
        System.out.println(s);
        botResponse = gson.fromJson(s, BotResponse.class);
        System.out.println(botResponse);
        // 返回机器人聊天信息
        return botResponse.getData().getInfo().getText();
    }
}
