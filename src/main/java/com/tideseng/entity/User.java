package com.tideseng.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/6 23:14
 */
@Data
public class User {

    private Integer id;
    private String username;
    private Date birthday;
    private Integer sex;

}
