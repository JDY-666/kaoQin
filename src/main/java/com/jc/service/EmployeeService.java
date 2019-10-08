package com.jc.service;

import com.jc.entity.Account;
import com.jc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Account> listEmployee(Integer page,Integer limit,String username);
    List<String> listEmName();
    Integer count();
    Integer add(Employee employee);
    Employee findById(Integer empId,String empNo);
    List<Employee> listAll();
    Integer delete(List<Integer> list);
    Integer updateEmployee(Employee employee);
}
