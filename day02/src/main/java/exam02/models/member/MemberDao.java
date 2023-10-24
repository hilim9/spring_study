package exam02.models.member;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // 자동 스캔 범위내에 있다고 알려주는 애노테이션 중 하나
public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member) {

        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
        member.setUserPw(userPw);
        members.put(member.getUserId(), member);
    }

    public Member get(String userId) {
        return members.get(userId);
    }
    
    // 전체 회원 데이터 조회
    public List<Member> gets() {

        /*// Collection은 강제 형변환이 되지 않는다
        Collection<Member> data = members.values();*/

        return new ArrayList<>(members.values()); // 반환값만 필요하기 때문에 바로 return
        
    }

    public boolean exists(String userId) {
        return members.containsKey(userId);
    }

    public static void clearData() {
        members.clear();
    }
}
