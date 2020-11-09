package com.tideseng.mybatis.session;

import com.tideseng.mybatis.config.Configuration;
import com.tideseng.mybatis.session.defalut.DefaultSqlSessionFactory;
import com.tideseng.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:08
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param configInputStream
     * @return
     */
    public SqlSessionFactory build(InputStream configInputStream){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(configInputStream);
        return  new DefaultSqlSessionFactory(cfg);
    }

}
