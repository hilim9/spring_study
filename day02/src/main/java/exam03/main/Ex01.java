package exam03.main;

import exam03.config.AppCtx1;
import exam03.models.member.InfoService;
import exam03.models.member.JoinService;
import exam03.models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx1.class);

        JoinService joinService = ctx.getBean(JoinService.class);
        InfoService infoService = ctx.getBean(InfoService.class);

        Member member = Member.builder()
                .userId("user01")
                .userPw("12345678")
                .confirmUserPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .agree(true)
                .regDt(LocalDateTime.now())
                .build();

        joinService.join(member);

        infoService.print();

        ctx.close();

    }
}
