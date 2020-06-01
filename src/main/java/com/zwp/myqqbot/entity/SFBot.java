package com.zwp.myqqbot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zwp
 * @create 2020-06-01 16:05
 * @deprecated 机器人请求协议
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SFBot {
    private String appid;
    private String userid;
    private String spoken;
}
