package com.zwp.myqqbot.service.impl;

import com.zwp.myqqbot.entity.Keyword;
import com.zwp.myqqbot.entity.Rubbish;
import com.zwp.myqqbot.model.*;
import com.zwp.myqqbot.model.PrivateMsg;
import com.zwp.myqqbot.model.Result;
import com.zwp.myqqbot.service.*;
import com.zwp.myqqbot.utils.KeywordsUtil;
import com.zwp.myqqbot.utils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static com.zwp.myqqbot.constant.URLConst.SEND_PRIVATE_MSG;
import static com.zwp.myqqbot.constant.URLConst.URL;


@Service
public class PrivateMsgServiceImpl implements PrivateMsgService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    KeywordService keywordService;
    @Autowired
    RubbishService rubbishService;
    @Autowired
    KmzService kmzService;
    @Autowired
    ChatServer chatServer;

    @Override
    public Result sendPrivateMsg(PrivateMsg msg) {
        Result result = restTemplate.postForObject(URL + SEND_PRIVATE_MSG, msg, Result.class);
        return result;
    }


    public ReplyMsg handlePrivateMsg(ReceiveMsg receiveMsg) {
        Long user_id = receiveMsg.getUser_id();
        String raw_message = receiveMsg.getRaw_message();

        //查询指令是否标准，不标准则反馈提示
        if (MsgUtil.getMenu(raw_message) != null) {
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setReply(MsgUtil.getMenu(raw_message));
            return replyMsg;
        }

        if (raw_message.contains("Kano")) {
            //　获取机器人回复
            String answer = chatServer.chatBot(raw_message);
            // 封装进返回值
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setReply(answer);
            return replyMsg;
        }

        //kmz
        if (raw_message.contains("看妹子")) {
            kmzService.sendMZPicByMsg(receiveMsg);
        }

        if (raw_message.contains("垃圾分类+")) {
            String type = rubbishService.handleRubbishType(raw_message);
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setReply(type);
            return replyMsg;
        }
        if (raw_message.contains("增加垃圾+")) {
            String name = raw_message.split("\\+")[1];
            String type = raw_message.split("\\+")[2];
            String reply = rubbishService.handleAddRubbish(new Rubbish(name, type));
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setReply(reply);
            return replyMsg;
        }
        if (raw_message.contains("列出关键词")) {
            String returnMsg = KeywordsUtil.getWordStringFromList(keywordService.getWordList(receiveMsg.getUser_id()));
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setReply(returnMsg);
            return replyMsg;
        }
        if (raw_message.contains("增加关键词")) {
            String keyword = raw_message.split("\\+")[1];
            boolean isSuccessAdd = keywordService.addKeyword(new Keyword(user_id, keyword));
            ReplyMsg replyMsg = new ReplyMsg();
            if (isSuccessAdd) {
                String keywordListString = KeywordsUtil.getWordStringFromList(keywordService.getWordList(receiveMsg.getUser_id()));
                replyMsg.setReply("增加关键词成功" + "\n" + keywordListString);
            } else {
                replyMsg.setReply("增加关键词失败,请联系3072994091");
            }
            return replyMsg;
        }
        if (raw_message.contains("删除关键词")) {
            String keyword = raw_message.split("\\+")[1];
            boolean isSuccessDel = keywordService.delKeyword(new Keyword(user_id, keyword));
            ReplyMsg replyMsg = new ReplyMsg();
            if (isSuccessDel) {
                String keywordListString = KeywordsUtil.getWordStringFromList(keywordService.getWordList(receiveMsg.getUser_id()));
                replyMsg.setReply("删除关键词成功" + "\n" + keywordListString);
            } else {
                replyMsg.setReply("删除关键词失败,不存在该关键词");
            }
            return replyMsg;
        }
        return null;
    }
}
