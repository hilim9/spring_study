package controllers.member;

import lombok.Data;

@Data
public class Address {

    private String zipcode; // 우편번호
    private String address; // 주소
    private String addressSub; // 나머지주소
}
