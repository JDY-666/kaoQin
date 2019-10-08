package com.jc.dao;

import com.jc.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesMapper {
    List<Classes> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    Integer count();
    Classes finById(Integer clId);
    Integer add(Classes classes);
    Integer update(Classes classes);
    Integer delete(@Param("list")List<Integer> list);
    List<Classes> listClass();
}
