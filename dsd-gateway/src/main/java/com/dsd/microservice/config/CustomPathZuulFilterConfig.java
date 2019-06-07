package com.dsd.microservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuyuzhu on 2019/6/7.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "zuul")
public class CustomPathZuulFilterConfig {

    private List<String> groovyFiltersPath;

    public List<String> getGroovyFiltersPath() {
        return groovyFiltersPath;
    }

    public void setGroovyFiltersPath(List<String> groovyFiltersPath) {
        this.groovyFiltersPath = groovyFiltersPath;
    }

}
