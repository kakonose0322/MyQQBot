package com.zwp.myqqbot.service;

import com.zwp.myqqbot.model.PrivateMsg;
import com.zwp.myqqbot.model.ReceiveMsg;
import com.zwp.myqqbot.model.ReplyMsg;
import com.zwp.myqqbot.model.Result;

/**
 * 私聊消息服务接口
 */
public interface PrivateMsgService {
    /**
     * 发送私聊消息
     *
     * @param msg
     * @return
     */
    Result sendPrivateMsg(PrivateMsg msg);

    /**
     * 由收到的私聊消息的内容转发给特定的方法
     *
     * @param receiveMsg
     * @return
     */
    ReplyMsg handlePrivateMsg(ReceiveMsg receiveMsg);
}
