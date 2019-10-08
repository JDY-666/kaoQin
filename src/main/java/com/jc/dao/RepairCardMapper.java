package com.jc.dao;


import com.jc.entity.RepairCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairCardMapper {
    List<RepairCard> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    Integer add(RepairCard repair);
    RepairCard findById(Integer repairId);
    Integer count(String username);
}
