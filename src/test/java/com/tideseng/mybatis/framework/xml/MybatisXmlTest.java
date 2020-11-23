package com.tideseng.mybatis.framework.xml;

import com.tideseng.mybatis.dao.xml.IUserDao;
import com.tideseng.mybatis.entity.User;
import com.tideseng.mybatis.framework.io.Resources;
import com.tideseng.mybatis.framework.session.SqlSession;
import com.tideseng.mybatis.framework.session.SqlSessionFactory;
import com.tideseng.mybatis.framework.session.SqlSessionFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/9 21:33
 */
@Slf4j
public class MybatisXmlTest {

    @Test
    public void findAll() throws IOException {
        // 1.读取配置文件（加载配置文件）
        InputStream in = Resources.getResourceAsStream("mybatis-config-xml.xml");
        // 2.使用建造者模式创建SqlSessionFactory工厂（将配置文件解析为包含连接和Mappers的配置类）
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂模式生产SqlSession对象（获取连接、传递封装的配置类）
        SqlSession sqlSession = factory.openSession();
        // 4.使用代理模式创建Dao接口的代理对象（生成代理对象，传递封装的Mappers）
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法（通过代理方法获取对应的Mapper）
        List<User> users = userDao.findAll();
        users.forEach(user -> log.info(user.toString()));
        // 6.释放资源
        sqlSession.close();
        in.close();
    }

}
