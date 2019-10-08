package com.jc.service;

import com.jc.entity.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> list(Integer page, Integer limit, String username);
    Integer count();
    Classes finById(Integer clId);
    Integer add(Classes classes);
    Integer update(Classes classes);
    Integer delete(List<Integer> list);
    List<Classes> listClass();
}
