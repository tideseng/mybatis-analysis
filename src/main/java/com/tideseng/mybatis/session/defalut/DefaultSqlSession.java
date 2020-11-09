package com.tideseng.mybatis.session.defalut;

import com.tideseng.mybatis.config.Configuration;
import com.tideseng.mybatis.session.SqlSession;
import com.tideseng.mybatis.session.proxy.MapperProxy;
import com.tideseng.mybatis.utils.DataSourceUtil;
import com.tideseng.mybatis.utils.Executor;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.List;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:47
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
    }

    @Override
    public <T> List<T> selectList(String namespace) {
        return new Executor().selectList(cfg.getMappers().get(namespace), connection);
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
