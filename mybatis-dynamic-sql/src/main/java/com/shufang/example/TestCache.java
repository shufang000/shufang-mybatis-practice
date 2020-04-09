package com.shufang.example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufang.mapper.CacheMapper;
import com.shufang.mapper.EmployeeMapper;
import com.shufang.pojo.Employee;
import com.shufang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestCache {

    /**
     * 这用来测试一级缓存，同一个selSession,同一个查询条件，没有增删改，没有手动
     * @throws IOException
     */
    @Test
    public void testFirstLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);

        Employee emp1 = mapper1.getEmpById("1004");

        System.out.println(emp1);

        //手动清空一级缓存,但是并不会清空二级缓存
        sqlSession.clearCache();

        Employee emp2 = mapper1.getEmpById("1004");
        System.out.println(emp2);

        MybatisUtil.closeSession(sqlSession);
    }

    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        //创建一个SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);

        System.out.println(mapper1.getEmpById("1004"));

        sqlSession.clearCache();
//        sqlSession.commit();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);

        System.out.println(mapper2.getEmpById("1004"));

        MybatisUtil.closeSession(sqlSession);
        MybatisUtil.closeSession(sqlSession2);
    }



    @Test
    public void testPageList() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");
        //创建一个SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);

        //实现分页，1代表第几页，5代表显示几条记录
        PageHelper.startPage(1,2);

        List<Employee> allEmps = mapper1.getAllEmps();

        //pageInfo，T的类型必须与上面list的类型保持一致，整个pageInfo中包含了所有的分页信息，可以返回给前端进行调用
        /**
         * PageInfo{pageNum=1, pageSize=2, size=2, startRow=1, endRow=2, total=11, pages=6,
         * list=Page{count=true, pageNum=1, pageSize=2, startRow=0, endRow=2, total=11, pages=6, reasonable=false, pageSizeZero=false}
         * [Employee{empId=1004, name='迈克尔', gender=2, age=18, dept=Department{dId=1089, dName='开发部', employeeList=null}},
         * Employee{empId=1017, name='BITEMAN', gender=38, age=1, dept=Department{dId=1089, dName='开发部', employeeList=null}}],
         * prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=8,
         * navigateFirstPage=1, navigateLastPage=6, navigatepageNums=[1, 2, 3, 4, 5, 6]}
         */

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(allEmps,4);

        //6
        System.out.println(pageInfo.getPages()); //获取分页总数

        System.out.println("----------------------------------------------");

        //[1, 2, 3, 4, 5, 6]代表导航页码
        System.out.println(Arrays.toString(pageInfo.getNavigatepageNums()));
        for (Employee allEmp : allEmps) {
            System.out.println(allEmp);
        }

        MybatisUtil.closeSession(sqlSession);
    }

}
