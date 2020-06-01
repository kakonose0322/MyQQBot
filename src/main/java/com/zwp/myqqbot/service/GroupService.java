package com.zwp.myqqbot.service;

import com.zwp.myqqbot.model.GroupInfo;
import java.util.List;

public interface GroupService {
    /**
     * 获取群
     *
     * @return
     */
    List<GroupInfo> getGroupInfo();
}
