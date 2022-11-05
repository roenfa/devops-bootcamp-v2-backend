package org.devops.bootcamp.actuators;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

    @Value("${spring.datasource.driverClassName}")
    String driverClassName;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.user}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Bean(name = "smartdb")
    public DataSource smartdb() {
        DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
        ds.setDriverClassName(driverClassName);
        return ds;
    }
}
