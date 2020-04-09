import com.shufang.mapper.UserMapper;
import com.shufang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {

    @Test
    public void test() throws IOException {

        SqlSession sqlSession = null;

        //获取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //1.首先获取SQLSession
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = sessionFactory.openSession();

        //2.通过SqlSession对象获取mapper映射,
        // getMapper（）会通过动态代理生成UserMapper接口的动态代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.getClass().getName());

        User user = mapper.getById("1001");

        //User{id=1001, name='shufang'}
        System.out.println(user);

//        User yangyao = new User(1003, "yangyao");
//        Integer insert = mapper.insert(yangyao);
//        System.out.println(insert);

        sqlSession.close();
    }
}
