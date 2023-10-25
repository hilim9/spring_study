package exam04.models.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder @Data
public class Member {
    private String userId; // 아이디
    private String userPw; // 비밀번호
    private String confirmUserPw; // 비밀번호 확인
    private String userNm; // 회원명
    private String email; // 이메일
    private boolean agree; // 약관 동의
    private LocalDateTime regDt; // 가입일시
    private String regDtStr;
}
