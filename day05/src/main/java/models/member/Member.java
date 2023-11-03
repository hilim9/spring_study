package models.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder @Data
@NoArgsConstructor
@AllArgsConstructor // 빌더 패턴을 사용할 때 기본생성자가 필요할 경우 사용 (편법)
                    // @NoArgsConstructor,@AllArgsConstructor
public class Member {

    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;
    private String mobile;
    private LocalDateTime regDt; // 가입일시
    private LocalDateTime modDt;


}
