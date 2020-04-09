package com.shufang.example;

import com.shufang.mapper.EmployeeMapper;
import com.shufang.pojo.Employee;
import com.shufang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSQL {

    @Test
    public void testUpdateBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee superman = new Employee("youfather", 1, 45);
        superman.setEmpId(1019);
        Employee biteman = new Employee("youmother", 2, 43);
        biteman.setEmpId(1020);
        Employee spirderman = new Employee("yoursister", 2, 18);
        spirderman.setEmpId(1021);

        Employee[]  emps = {superman,biteman,spirderman};

        mapper.updateBatch(emps);
        MybatisUtil.closeSession(sqlSession);

    }
    @Test
    public void testInsertBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> emps = new ArrayList<Employee>();
        Employee superman = new Employee("SUPERMAN", 1, 27);
        Employee biteman = new Employee("BITEMAN", 1, 38);
        Employee spirderman = new Employee("SPIDERMAN", 1, 18);
        emps.add(superman);
        emps.add(biteman);
        emps.add(spirderman);

        mapper.insertBatch(emps);

        MybatisUtil.closeSession(sqlSession);
    }

    @Test
    public  void testDeleteByOr() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<String> strings = new ArrayList<String>();
        strings.add("1012");
        strings.add("1015");
        mapper.deleteByOr(strings);

        MybatisUtil.closeSession(sqlSession);
    }

    @Test
    public  void testDeleteByList() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<String> strings = new ArrayList<String>();
        strings.add("1013");
        strings.add("1014");
        mapper.deleteMoreByList(strings);

        MybatisUtil.closeSession(sqlSession);
    }

    @Test
    public  void testInsert() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee(null, "baisuishan", 1, 88, null);
        mapper.insertEmp(employee);

        MybatisUtil.closeSession(sqlSession);
    }


    @Test
    public  void testDeleteBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.deleteBatch("1001,1002,1003");

        MybatisUtil.closeSession(sqlSession);
    }

    /**
     * 1.<if test=""><if/>: 根据传入的参数条件，筛选不同的SQL语句进行拼接
     * 2.<where> ... demo block such as <if></if> ...</where> 给SQL加上where 并且去掉where后面多余的 and
     * 3.<trim prefix ="where" suffixOverrides = "and|or">... demo block such as <if></if> ...</trim>  给SQL添加前缀，并且去掉后缀多余的and 或者 or
     * 4.<set></set>: 主要是解决update 在某些参数没有传入的时候，去掉多余的·,· 以及加上 set关键字
     * 总结：-----> 实际工作中还是<trim></trim>用得最多
     * @throws IOException
     */
    @Test
    public  void testSQL() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        //TODO 这里就是测试的方法的调用
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpId(1010);
        employee.setName("SuperMan");
        employee.setGender(2);
        employee.setAge(26);
        List<Employee> emps = mapper.getEmpsByMultiFeature(employee);


//        List<Employee> emps = mapper.getEmpsByOneFeature(employee);
        for (Employee emp : emps) {
            System.out.println(emp);
        }

        MybatisUtil.closeSession(sqlSession);
    }

}
