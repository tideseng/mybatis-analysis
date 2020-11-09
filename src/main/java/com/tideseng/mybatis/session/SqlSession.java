package com.tideseng.mybatis.session;

import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:08
 * 自定义Mybatis中和数据库交互的核心类，可以创建dao接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    <T> List<T> selectList(String statement);

    /**
     * 释放资源
     */
    void close();

}
