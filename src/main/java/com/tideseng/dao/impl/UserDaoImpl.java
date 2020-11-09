package com.tideseng.dao.impl;

import com.tideseng.dao.IUserDao;
import com.tideseng.entity.User;
import com.tideseng.mybatis.session.SqlSession;
import com.tideseng.mybatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:00
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
        List<User> users = sqlSession.selectList("com.tideseng.dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }

}
