package com.tideseng.mybatis.utils;

import com.tideseng.mybatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:52
 * 用于创建数据源的工具类
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
