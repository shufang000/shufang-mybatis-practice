import com.shufang.mapper.EmployeeMapper;
import com.shufang.pojo.Employee;
import com.shufang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestMybatisCache {


    /**
     * 用来测试1级缓存
     * 同一个SQlSession调用同一个SQL语句的时候的缓存叫做1级缓存，一级缓存在以下情况会失效：
     * 1、不同的SqlSession对应不同的一级缓存
     * 2、同一个SqlSession但是查询的条件不同
     * 3、同一个SqlSession的两次操作之间执行了任意一次增删改操作
     * 4、同一个SqlSession手动清空了缓存
     * <p>
     * 一级缓存的
     */
    @Test
    public void testCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee emp = mapper.getEmpByEmpId("1006");
        Employee emp1 = mapper.getEmpByEmpId("1006");

        //只有在第一次查询的时候，才会执行SQL，将取出的对象缓存在缓存中
        System.out.println(emp);
        System.out.println("---------------");
        System.out.println(emp1);

        MybatisUtil.closeSession(sqlSession);

    }

    @Test
    public void testSecondCache() throws IOException {

        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSession("mybatis-config.xml");

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee emp1 = mapper.getEmpByEmpId("1006");
        System.out.println(emp1);
        System.out.println("------------8888888888888-------");

//        sqlSession.commit(); //二级缓存只有在sqlsession提交或者关闭的时候才生效

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        Employee emp2 = mapper1.getEmpByEmpId("1006");
        System.out.println(emp2);


        MybatisUtil.closeSession(sqlSession);
        MybatisUtil.closeSession(sqlSession1);
    }
}
