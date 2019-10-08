package com.jc.service;

import com.jc.entity.RepairCard;

import java.util.List;

public interface RepairCardService {
    List<RepairCard> list(Integer page, Integer limit, String username);
    Integer add(RepairCard repairCard);
    RepairCard findById(Integer repairId);
    Integer count(String username);
}
