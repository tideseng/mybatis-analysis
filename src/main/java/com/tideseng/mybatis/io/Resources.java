package com.tideseng.mybatis.io;

import java.io.InputStream;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:05
 * 使用类加载器读取配置文件
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }

}
