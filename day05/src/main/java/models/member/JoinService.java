package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JoinService {

    private final JoinValidator validator; // models.validator
    private final MemberDao memberDao;

    public void join(RequestJoin form) {

        validator.check(form);

        Member member2 = new ModelMapper().map(form, Member.class);

        Member member = Member.builder()
                .userId(form.getUserId())
                .userNm(form.getUserNm())
                .userPw(form.getUserPw())
                .email(form.getEmail())
                .mobile(form.getMobile())
                .build();

        memberDao.register(member);
    }

}
