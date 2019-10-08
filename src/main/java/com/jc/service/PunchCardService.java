package com.jc.service;

import com.jc.entity.PunchCard;

import java.util.List;

public interface PunchCardService {
    List<PunchCard> list(Integer page, Integer limit, String username);
    Integer add(PunchCard punchCard);
    PunchCard findById(Integer punchId);
    Integer count();
}
