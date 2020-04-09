package com.shufang.mapper;

import com.shufang.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {


    //查询一个员工信息byId
    Employee getEmpById(String id);


    //获取所有员工
    List<Employee> getEmployees();


    //添加一个员工
    Boolean insertEmp(Employee employee);

    //更新一个员工的员工信息
    void updateEmp(Employee employee);


    //删除一个员工
    Boolean deleteEmp(String id);
}
