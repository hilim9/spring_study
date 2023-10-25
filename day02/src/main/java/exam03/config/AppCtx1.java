package exam03.config;

import exam03.models.member.MemberDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(AppCtx2.class)
@Configuration
public class AppCtx1 {
    
    // Spring 5 버전은 오류 발생 (6버전은 오류 발생 하지 않음)
    // 동일한 객체가 두 개 설정되어 있을 때 어느 객체인지 모르기 때문

    @Bean
    /*@Qualifier("mDao")*/ // 객체 이름 변경 가능
    public MemberDao memberDao() {
        return new MemberDao();
    }
    
    /*@Bean
    public MemberDao memberDao2() {
        return new MemberDao();
    }*/

}
