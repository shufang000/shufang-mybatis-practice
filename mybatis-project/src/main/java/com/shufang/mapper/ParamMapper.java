package com.shufang.mapper;

import com.shufang.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ParamMapper {

    Employee getEmpById(String id);

    //根据empId 和 name查询员工信息
    Employee getEmpByIdAndName(String id,String name);


    //通过@Param注解来指定参数放进map的key
    Employee getEmpByIdAndNameParam(@Param("id")String id, @Param("name") String name);


    //当传输Map参数时候
    Employee getEmpByMap(Map<String ,Object> map);
}
