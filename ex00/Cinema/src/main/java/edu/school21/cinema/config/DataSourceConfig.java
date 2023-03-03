package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:../application.properties")
public class DataSourceConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.driver.name}")
    private String dbDriver;

    @Bean(destroyMethod = "", name = "EmbeddedDataSource")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(dbDriver);
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }
}
