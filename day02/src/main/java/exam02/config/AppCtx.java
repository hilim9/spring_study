package exam02.config;

import exam02.models.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    /*
    @Bean
    public MemberDao memberDao() {

        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {

        // Setter 주입
        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao());

        return joinValidator;

    }

    @Bean
    public JoinService joinService() {

        return new JoinService(joinValidator(), memberDao());
    }

    @Bean
    public InfoService infoService() {

        return new InfoService(memberDao());
    }*/

}
