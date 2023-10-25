package exam04.models.member;

import exam04.commons.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {


    private final Validator<Member> validator;

    private final MemberDao memberDao;

    public void join(Member member) {

        validator.check(member);

        memberDao.register(member);
    }

}
