package com.jc.service.impl;

import com.jc.dao.EmployeeMapper;
import com.jc.entity.Account;
import com.jc.entity.Employee;
import com.jc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public List<Account> listEmployee(Integer page, Integer limit, String username) {
        return mapper.listEmployee(page,limit,username);
    }

    @Override
    public List<String> listEmName() {
        return mapper.listEmName();
    }

    @Override
    public Integer count() {
        return mapper.count();
    }

    @Override
    public Integer add(Employee employee) {
        return mapper.add(employee);
    }

    @Override
    public Employee findById(Integer empId,String empNo) {
        return mapper.findById(empId,empNo);
    }

    @Override
    public List<Employee> listAll() {
        return mapper.listAll();
    }

    @Override
    public Integer delete(List<Integer> list) {
        return mapper.delete(list);
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        return mapper.updateEmployee(employee);
    }
}
