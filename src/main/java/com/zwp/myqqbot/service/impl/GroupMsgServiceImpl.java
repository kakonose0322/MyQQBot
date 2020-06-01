package com.zwp.myqqbot.service.impl;

import com.zwp.myqqbot.model.*;
import com.zwp.myqqbot.service.*;
import com.zwp.myqqbot.constant.URLConst;
import com.zwp.myqqbot.entity.Rubbish;
import com.zwp.myqqbot.model.GroupMsg;
import com.zwp.myqqbot.model.ReceiveMsg;
import com.zwp.myqqbot.model.ReplyMsg;
import com.zwp.myqqbot.model.Result;
import com.zwp.myqqbot.service.GroupMsgService;
import com.zwp.myqqbot.service.KeywordService;
import com.zwp.myqqbot.service.PrivateMsgService;
import com.zwp.myqqbot.service.RubbishService;
import com.zwp.myqqbot.utils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GroupMsgServiceImpl implements GroupMsgService {
    @Autowired
    PrivateMsgService privateMsgService;
    @Autowired
    RubbishService rubbishService;
    @Autowired
    KmzService kmzService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    KeywordService keywordService;
    @Autowired
    ChatServer chatServer;

    @Override
    public Result sendGroupMsg(GroupMsg groupMsg) {
        Result result = restTemplate.postForObject(URLConst.URL + URLConst.SEND_GROUP_MSG, groupMsg, Result.class);
        return result;
    }


    public ReplyMsg handleGroupMsg(ReceiveMsg receiveMsg) {
        String raw_message = receiveMsg.getRaw_message();

        //关键词监控
        keywordService.getPrivateMsgOnKeyword(receiveMsg);

        if (raw_message.contains("Kano")) {
            //　获取机器人回复
            String answer = chatServer.chatBot(raw_message);
            // 封装进返回值
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setReply(answer);
            return replyMsg;
        }

        //KMZ不需要@我
        if (raw_message.contains("看妹子")) {
            kmzService.sendMZPicByMsg(receiveMsg);
        }

        //只有at我的才可以触发
        if (raw_message.contains("CQ:at,qq=2708236762")) {
            //查询指令是否标准，不标准则反馈提示
            if (MsgUtil.getMenu(raw_message) != null) {
                ReplyMsg replyMsg = new ReplyMsg();
                replyMsg.setReply(MsgUtil.getMenu(raw_message));
                return replyMsg;
            }
            if (raw_message.contains("垃圾分类+")) {
                String type = rubbishService.handleRubbishType(raw_message);
                ReplyMsg replyMsg = new ReplyMsg();
                replyMsg.setReply(type);
                replyMsg.setAt_sender(true);
                return replyMsg;
            }
            if (raw_message.contains("增加垃圾+")) {
                String name = raw_message.split("\\+")[1];
                String type = raw_message.split("\\+")[2];
                String reply = rubbishService.handleAddRubbish(new Rubbish(name, type));
                ReplyMsg replyMsg = new ReplyMsg();
                replyMsg.setReply(reply);
                replyMsg.setAt_sender(true);
                return replyMsg;
            }
        }
        return null;
    }
}
