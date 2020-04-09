package com.shufang.mapper;

import com.shufang.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    // 底层mybatis'会通过反射创建一个动态代理的实现类对象
    List<Employee> getEmpsByMultiFeature(Employee emp);

    // 根据传入参数中的一个来查询员工
    public List<Employee> getEmpsByOneFeature(Employee emp);


    /**
     *     <!-- void insertEmp(Employee emp);   -->
     *     <insert id="insertEmp">
     *         insert into hr_emp(name,gender,age) values(
     *         <trim suffixOverrides=",">
     *                 <choose>
     *                     <when test="name == '哇哈哈' and name != null">
     *                         'wahaha',
     *                     </when>
     *                     <otherwise>
     *                         #{name},
     *                     </otherwise>
     *                 </choose>
     *                 #{gender},
     *                 #{age},
     *         </trim>
     *         )
     *     </insert>
     * @param emp
     */
    //插入员工，使用choose when otherwise
    void insertEmp(Employee emp);

    //通过一个集合传入id，实现批量删除
    void deleteBatch(@Param("ids") String ids);

    // 批量删除的接口方法,通过字符串的形式
    void deleteMoreByList(@Param("ids") List<String> ids);

    //通过delete from hr_emp where empid = 1 or empid = 2 or empid = 3
    void deleteByOr(@Param("ids") List<String> ids);

    //实现批量添加
    void insertBatch(List<Employee> emps);


    //实现批量修改成相对内容
    void updateBatch(@Param("emps") Employee[] emps);

    //根据empid查询员工信息
    Employee getEmpByEmpId(String id);


}
