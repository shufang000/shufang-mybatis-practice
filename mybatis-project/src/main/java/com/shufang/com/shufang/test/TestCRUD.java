package com.shufang.com.shufang.test;

import com.shufang.mapper.EmployeeMapper;
import com.shufang.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestCRUD {

    @Test
    public void testCrud() {

        SqlSession sqlsession = null;
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

            sqlsession = sqlSessionFactory.openSession(true);//代表可以自动提交事务

            EmployeeMapper mapper = sqlsession.getMapper(EmployeeMapper.class);

            /**
             * 测试相关的获取全量数据的方法
             */
//            List<Employee> employees = mapper.getEmployees();
//
//            for (Employee employee : employees) {
//                System.out.println(employee);
//            }


            /**
             * 测试通过id来获取某个Employee
             */
//            System.out.println(mapper.getEmpById("1001"));

            /**
             * 插入一个employee,同时将主键放进当前插入对象的empId中
             */
//            Employee superMan = new Employee(null, "SuperMan", 2, 26, 10086);
//            mapper.insertEmp(superMan);
//            System.out.println(superMan.getEmpId());


//            sqlsession.commit(); //手动提交事务


//            Boolean flag = mapper.deleteEmp("1007");
//            System.out.println(flag);

//            mapper.updateEmp(new Employee(1004,"爱心觉罗斯密达",2,18,1088));




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != sqlsession) {
                sqlsession.close();
            }
        }
    }
}
