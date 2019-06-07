package com.dsd.microservice.config;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by yuyuzhu on 2019/6/7.
 */
@Component
public class GroovyFiltersInitializer {

    @Autowired
    private CustomPathZuulFilterConfig config;

    @PostConstruct
    private void initGroovyFilters() throws Exception {

        List<String> groovyFiltersPath = config.getGroovyFiltersPath();

        if(groovyFiltersPath == null || groovyFiltersPath.size() == 0) {
            return;
        }

        FilterLoader.getInstance().setCompiler(new GroovyCompiler());
        FilterFileManager.setFilenameFilter(new GroovyFileFilter());

        String[] filterDirectoryList = groovyFiltersPath.toArray(new String[0]);
        FilterFileManager.init(5, filterDirectoryList);

//        logger.info("Groovy Filter file manager started");
    }

}
