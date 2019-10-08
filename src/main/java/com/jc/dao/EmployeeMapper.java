package com.jc.dao;

import com.jc.entity.Account;
import com.jc.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Account> listEmployee(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    List<String> listEmName();
    List<Employee> listAll();
    Integer count();
    Integer add(Employee employee);
    Employee findById(@Param("empId") Integer empId,@Param("empNo") String empNo);
    Integer delete(@Param("list")List<Integer> list);
    Integer updateEmployee(Employee employee);
}
