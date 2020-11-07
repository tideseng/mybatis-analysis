package com.tideseng.mybatis.xml.dao;

import com.tideseng.mybatis.xml.entity.User;

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
