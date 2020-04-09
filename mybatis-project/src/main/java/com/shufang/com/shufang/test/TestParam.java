package com.shufang.com.shufang.test;

import com.shufang.mapper.ParamMapper;
import com.shufang.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestParam {

    @Test
    public void testParam() throws IOException {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        ParamMapper mapper = sqlSession.getMapper(ParamMapper.class);

        Employee emp = mapper.getEmpById("1010");

        System.out.println(emp);

//        Employee shufang = mapper.getEmpByIdAndName("1001", "shufang");

//        System.out.println(shufang);

//
//        Map<String ,Object> map = new HashMap<String ,Object>();
//
//        map.put("id",1001);
//        map.put("name","shufang");
//        Employee employee = mapper.getEmpByMap(map);


        Employee employee = mapper.getEmpByIdAndNameParam("1010", "SuperMan");
        System.out.println(employee);




        sqlSession.close();
    }
}
