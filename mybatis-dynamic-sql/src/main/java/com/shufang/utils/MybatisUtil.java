package com.shufang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类，主要是用来开启关闭SqlSession的
 */
public class MybatisUtil {

    public static SqlSessionFactory getSqlSession(String path) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(path);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }


    public static void closeSession(SqlSession session) {
        if (null == session) return;
        session.close();
    }
}
