package com.it.dao;

import com.it.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    public static void main(String[] args) throws IOException {
        // 1. 获取文件流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 创建工厂的构建器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 3. 创建SqlSession的工厂
        SqlSessionFactory factory = builder.build(in);

        // 3. 创建SqlSession
        SqlSession session = factory.openSession();

        // 4. 创建接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        // 查看是否是代理对象？
        System.out.println(userDao.getClass());

        // 5. 调用方法
        List<User> list = userDao.findAll();
        list.forEach(System.out::println);

        // 6. 关闭，释放资源
        session.close();
        in.close();
    }
}
