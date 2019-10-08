package com.jc.dao;

import com.jc.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    List<Department> listDep(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    Integer addDep(Department department);
    Department findById(Integer depId);
    Integer updateDep(Department department);
    List<Department> listDepName();
    Integer count();
    Integer delete(@Param("list")List<Integer> list);
}
