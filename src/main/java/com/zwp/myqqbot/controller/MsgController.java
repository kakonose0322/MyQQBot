package com.zwp.myqqbot.controller;

import com.zwp.myqqbot.model.PrivateMsg;
import com.zwp.myqqbot.model.ReplyMsg;
import com.zwp.myqqbot.model.Result;
import com.zwp.myqqbot.service.MsgService;
import com.zwp.myqqbot.service.PrivateMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    MsgService msgService;
    @Autowired
    PrivateMsgService privateMsgService;

    @RequestMapping("/sendPrivateMsg")
    public Result sendPrivateMsg(PrivateMsg msg) {
        return privateMsgService.sendPrivateMsg(msg);
    }

    /**
     * 消息上报接口
     *
     * @param request
     */
    @RequestMapping("/receive")
    public ReplyMsg receive(HttpServletRequest request) {
        return msgService.receive(request);
    }
}
