package com.tideseng.mybatis.annotation;

import com.tideseng.mybatis.annotation.dao.IUserDao;
import com.tideseng.mybatis.annotation.dao.impl.UserDaoImpl;
import com.tideseng.mybatis.annotation.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/6 23:59
 */
@Slf4j
public class MybatisAnnotationTest {

    /**
     * 默认使用代理对象执行方法
     * @throws IOException
     */
    @Test
    public void findAll() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config-annotation.xml");
        // 2.使用建造者模式创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂模式生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4.使用代理模式创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        users.forEach(user -> log.info(user.toString()));
        // 6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 使用自定义实现类执行方法
     * @throws IOException
     */
    @Test
    public void findAllImpl() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config-annotation.xml");
        // 2.使用建造者模式创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.创建Dao接口的实现类
        IUserDao userDao = new UserDaoImpl(factory);
        // 4.使用代理对象执行方法
        List<User> users = userDao.findAll();
        users.forEach(user -> log.info(user.toString()));
        in.close();
    }

}
