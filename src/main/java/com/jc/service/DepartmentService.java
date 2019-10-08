package com.jc.service;

import com.jc.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> listDep(Integer page, Integer limit, String username);
    Integer addDep(Department department);
    Department findById(Integer depId);
    Integer updateDep(Department department);
    List<Department> listDepName();
    Integer count();
    Integer delete(List<Integer> list);
}
