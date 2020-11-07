package com.tideseng.mybatis.annotation.dao.impl;

import com.tideseng.mybatis.annotation.dao.IUserDao;
import com.tideseng.mybatis.annotation.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 0:15
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    /**
     * 注入SqlSessionFactory
     * @param factory
     */
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    /**
     * statement: 类名.方法名
     * @return
     */
    @Override
    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> users = sqlSession.selectList("com.tideseng.mybatis.annotation.dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }

}
