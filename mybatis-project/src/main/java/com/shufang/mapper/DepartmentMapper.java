package com.shufang.mapper;

import com.shufang.pojo.Department;

public interface DepartmentMapper {

    //根据部门id查询部门
    Department getDeptById(String id);
}
