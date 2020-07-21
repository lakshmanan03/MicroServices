package com.scgapps.mobile.api.library.config;

import com.scgapps.mobile.api.library.routing.TenantAwareRoutingSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Autowired
    DatabaseConfigurations databaseConfigurations;

    @Bean
    public DataSource createDataSource() {
        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource(TenantConstants.defaultTenant);
        dataSource.setTargetDataSources(databaseConfigurations.createTargetDataSources());
        dataSource.afterPropertiesSet();
        return dataSource;
    }
}
