package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoin {

    @NotBlank
    @Size(min=6)
    private String userId;

    @NotBlank
    @Size(min=8 ,max=16)
    private String userPw;

    @NotBlank
    @Size(min=8 ,max=16)
    private String confirmUserPw;

    @NotBlank
    private String userNm;

    @NotBlank
    @Email
    private String email;

    private String mobile;

    @AssertTrue
    private boolean agree;

    private Address addr; // addr.address, addr.zipcode 변수명으로 접근

    //private String[] hobby;
    //private List<String> hobby;
}
