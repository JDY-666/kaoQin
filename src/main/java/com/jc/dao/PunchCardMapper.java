package com.jc.dao;

import com.jc.entity.PunchCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PunchCardMapper {
    List<PunchCard> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    Integer add(PunchCard punchCard);
    PunchCard findById(Integer punchId);
    Integer count();
}
