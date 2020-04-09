package com.shufang.com.shufang.test;

import com.shufang.mapper.EmployeeSelectMapper;
import com.shufang.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


public class TestSelect {

    @Test
    public void testSelect() throws IOException {

        //这里需要传入的是全局配置文件的xml 类路径
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeSelectMapper mapper = sqlSession.getMapper(EmployeeSelectMapper.class);

        Employee emp = mapper.getById("1006");
        System.out.println(emp);


        Integer count = mapper.getCount();
        System.out.println(count);


        System.out.println("------------------------");

        /**
         * empid=1009
         * gender=2
         * name=lily
         * deptid=1111
         * age=16
         */
        Map<String, Object> empMapById = mapper.getEmpMapById("1009");

        for (Map.Entry<String, Object> stringObjectEntry : empMapById.entrySet()) {
            System.out.println(stringObjectEntry);
        }


        sqlSession.close();


    }
}
