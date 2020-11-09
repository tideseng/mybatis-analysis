package com.tideseng.mybatis.session;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:08
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();

}
