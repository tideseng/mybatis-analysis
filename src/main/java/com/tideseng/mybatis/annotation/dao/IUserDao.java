package com.tideseng.mybatis.annotation.dao;

import com.tideseng.mybatis.annotation.entity.User;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from user")
    List<User> findAll();

}
