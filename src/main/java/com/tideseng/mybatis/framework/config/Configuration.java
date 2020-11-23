package com.tideseng.mybatis.framework.config;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 章佳欢-何鑫
 * @create 2020/11/8 23:30
 */
@Data
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public void setMappers(Map<String, Mapper> mappers) {
        // 此处需要使用追加的方式
        this.mappers.putAll(mappers);
    }

}
