package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {

    @Value("${environment}")
    private String env;

    @Value("${db.username.dev}")
    private String usernameDev;

    @Value("${db.password.dev}")
    private String passwordDev;

    @Value("${db.username.prod}")
    private String usernameProd;

    @Value("${db.password.prod}")
    private String passwordProd;

    @Bean(destroyMethod = "close") // 소멸될때 자동으로 자원 해제
    public DataSource dataSource() {

        String username = env.equals("prod") ? usernameProd : usernameDev;
        String password = env.equals("prod") ? passwordProd : passwordDev;

        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername(username);
        ds.setPassword(password);

        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource());
    }
}
