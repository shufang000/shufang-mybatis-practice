package com.shufang.mapper;

import com.shufang.pojo.Employee;

import java.util.List;

public interface CacheMapper {

    //根据id获取Employee
    Employee getEmpById(String id);

    //获取所有的emp
    List<Employee> getAllEmps();
}
