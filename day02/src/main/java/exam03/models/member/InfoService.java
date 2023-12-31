package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class InfoService {

    //@Autowired
    private MemberDao memberDao;
    @Autowired
    private Optional<MemberDao> opt;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

    //@Autowired(required = false)
    @Autowired/*(required = false)*/ // set형태 메서드도 @Autowired 사용 가능
    public void setFormatter(@Nullable DateTimeFormatter formatter) {

        System.out.println("유입");
        System.out.println(formatter); // null

        this.formatter = formatter;
    }

    public void print() {

        MemberDao memberDao = opt.get();
        List<Member> members = memberDao.gets();
        members.stream().map(this::toConvert).forEach(System.out::println);
    }

    private Member toConvert(Member member) {

        // required = false로 설정 시 formatter가 호출이 되지 않기 때문에 값이 null(참조변수 이기 때문)
        if (formatter == null) {
            return member;
        }

        String regDtStr = formatter.format(member.getRegDt());
        member.setRegDtStr(regDtStr);

        return member;


    }

}
