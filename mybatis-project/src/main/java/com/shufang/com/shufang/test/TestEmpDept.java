package com.shufang.com.shufang.test;

import com.shufang.mapper.EmpDeptMapper;
import com.shufang.mapper.ParamMapper;
import com.shufang.pojo.Department;
import com.shufang.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestEmpDept {

    @Test
    public void testEmpDept() throws IOException {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmpDeptMapper mapper = sqlSession.getMapper(EmpDeptMapper.class);

        List<Employee> allEmp = mapper.getAllEmp();

        /**
         * 演示console的结果：
         * Employee{empId=1009, name='lily', gender=2, age=16, dept=Department{dId=1111, dName='产品部'}}
         * Employee{empId=1010, name='SuperMan', gender=2, age=26, dept=Department{dId=10086, dName='电信开发部'}}
         */
//        for (Employee employee : allEmp) {
//            System.out.println(employee);
//        }
//
//        System.out.println("-------------------------");
//
//        Employee emp = mapper.getEmpById("1010");
//        System.out.println(emp.getGender());


        System.out.println("--------------------------");
//
//        Department deptEmpbyId = mapper.getDeptEmpbyId("10086");
//
//        System.out.println(deptEmpbyId);

        Department department = mapper.getOnlyDeptById("10086");

        System.out.println(department);

        sqlSession.close();
    }
}
