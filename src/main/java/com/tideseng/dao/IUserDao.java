package com.tideseng.dao;

import com.tideseng.entity.User;
import com.tideseng.mybatis.annotation.Select;

import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 22:59
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

}
