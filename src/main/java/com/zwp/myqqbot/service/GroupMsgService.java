package com.zwp.myqqbot.service;

import com.zwp.myqqbot.model.GroupMsg;
import com.zwp.myqqbot.model.ReceiveMsg;
import com.zwp.myqqbot.model.ReplyMsg;
import com.zwp.myqqbot.model.Result;

public interface GroupMsgService {
    /**
     * 发送群消息
     *
     * @param groupMsg
     * @return
     */
    Result sendGroupMsg(GroupMsg groupMsg);

    /**
     * 由收到的群消息的内容转发给特定的方法
     *
     * @param receiveMsg
     */
    ReplyMsg handleGroupMsg(ReceiveMsg receiveMsg);
}
