package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("models")
public class AppCtx {

    @Bean(destroyMethod = "close") // 소멸시 호출 메서드 정의 (외부 라이브러리, 외부 클래스)
    public DataSource dataSource() {
        DataSource ds = new DataSource();

        /* 데이터 베이스 연결 설정 S */
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("spring6");
        ds.setPassword("_aA123456");
        /* 데이터 베이스 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setInitialSize(2); // 초기 커넥션 개수 (기본값 10)
        ds.setMaxActive(10); // 최대 커넥션 개수 (기본값 100)
        ds.setTestWhileIdle(true); // 유휴 상태로 있는 동안 검사할지 여부 지정
        ds.setTimeBetweenEvictionRunsMillis(3000); // 3초 마다 연결 상태 확인 (기본값 5초)
        ds.setMinEvictableIdleTimeMillis(30 * 1000); // 유효 상태를 유지할 최초 시간 (기본값 60초)
                                        // 30초
        /* 커넥션 풀 설정 E */

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
