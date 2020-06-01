package com.zwp.myqqbot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwp.myqqbot.entity.Keyword;
import java.util.List;

public interface KeywordMapper extends BaseMapper<Keyword> {
    List<Keyword> getAllData();
}
