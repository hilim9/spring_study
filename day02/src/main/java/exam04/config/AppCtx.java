package exam04.config;

import exam04.models.member.MemberDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration

// 설정한 하위 범위 패키지 전부 스캔
/*@ComponentScan(basePackages = "exam04.models",
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class))*/
@ComponentScan(basePackages = "exam04.models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class))
public class AppCtx {

    /*@Bean
    public MemberDao memberDao() {
        System.out.println("여기?");
        return new MemberDao();
    }*/


}
