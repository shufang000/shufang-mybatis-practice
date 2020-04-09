package com.shufang.mapper;

import com.shufang.pojo.Employee;

import java.util.Map;

public interface EmployeeSelectMapper {


    //获取一个Emp对象
    Employee getById(String id);

    //获取员工数量
    Integer getCount();

    //以map的形式获取一个Emp
    Map<String ,Object> getEmpMapById(String id);


}
