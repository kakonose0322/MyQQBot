package com.zwp.myqqbot.service;

import com.zwp.myqqbot.entity.Csdn;

public interface CsdnService {
    /**
     * 获取个人主页的信息
     * @return
     */
    Csdn getCsdnHomeInfo();

    /**
     * 访问所有博文的内容
     */
    void visitAllBlogs();
}
