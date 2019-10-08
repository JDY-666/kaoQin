package com.jc.service.impl;

import com.jc.dao.DepartmentMapper;
import com.jc.entity.Department;
import com.jc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper mapper;
    @Override
    public List<Department> listDep(Integer page, Integer limit, String username) {
        if (page == 1){
            return mapper.listDep(page,limit,username);
        }
        return mapper.listDep((page-1)*limit,limit,username);
    }

    @Override
    public Integer addDep(Department department) {
        return mapper.addDep(department);
    }

    @Override
    public Department findById(Integer depId) {
        return mapper.findById(depId);
    }

    @Override
    public Integer updateDep(Department department) {
        return mapper.updateDep(department);
    }

    @Override
    public List<Department> listDepName() {
        return mapper.listDepName();
    }

    @Override
    public Integer count() {
        return mapper.count();
    }

    @Override
    public Integer delete(List<Integer> list) {
        return mapper.delete(list);
    }
}
