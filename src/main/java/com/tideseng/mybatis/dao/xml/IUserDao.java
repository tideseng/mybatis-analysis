package com.tideseng.mybatis.dao.xml;

import com.tideseng.mybatis.entity.User;

import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/6 23:14
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

}
