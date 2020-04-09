package com.shufang.mapper;

import com.shufang.pojo.Department;
import com.shufang.pojo.Employee;

import java.util.List;

public interface EmpDeptMapper {

    List<Employee> getAllEmp();

    Employee getEmpById(String id);

    Department getDeptEmpbyId(String id);

    //一对多映射的分布实现
    Department getOnlyDeptById(String id);
    List<Employee> getEmpsByDeptId(String did);

}
