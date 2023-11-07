package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig2 {

    @Profile("dev")
    @Configuration
    public static class DbDevConfig {

        @Bean(destroyMethod = "close") // 소멸될때 자동으로 자원 해제
        public DataSource dataSource() {
            System.out.println("dev profile!!");

            DataSource ds = new DataSource();
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("spring6");
            ds.setPassword("_aA123456");

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

    @Profile("prod")
    @Configuration
    public static class DbProdConfig {

        @Bean(destroyMethod = "close") // 소멸될때 자동으로 자원 해제
        public DataSource dataSource() {
            System.out.println("prod profile!!");

            DataSource ds = new DataSource();
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("spring6");
            ds.setPassword("_aA123456");

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


}
