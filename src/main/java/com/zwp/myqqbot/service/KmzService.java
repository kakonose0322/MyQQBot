package com.zwp.myqqbot.service;

import com.zwp.myqqbot.model.ReceiveMsg;
import com.zwp.myqqbot.model.ReplyMsg;
import java.util.List;

public interface KmzService {
    /**
     * 由消息内容与消息类型获得反馈消息或直接发送mz图片
     * @param receiveMsg
     * @return
     */
    ReplyMsg sendMZPicByMsg(ReceiveMsg receiveMsg);

    /**
     * 获取n张妹子图的key
     * @param n
     * @return
     */
    List<String> getKmzImageKey(int n);
}
