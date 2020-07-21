package com.scgapps.mobile.api.library.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ConfigurationProperties(prefix = "tenants")
public class DatabaseConfigurations {
    private Map<String, DatabaseConfiguration> datasources = new HashMap<>();

    public Map<String, DatabaseConfiguration> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, DatabaseConfiguration> datasources) {
        this.datasources = datasources;
    }

    public Map<Object, Object> createTargetDataSources() {
        Map<Object, Object> result = new HashMap<>();

        datasources.forEach((key, value) ->  result.put(key, value.createDataSource()));
        Iterator it=   result.keySet().iterator();
        while(it.hasNext()) {
            String schema= (String)it.next();
        }

        return result;
    }
}