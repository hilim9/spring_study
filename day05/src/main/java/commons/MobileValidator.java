package commons;

public interface MobileValidator {

    default boolean checkMobile(String num) {

        /*
        * 010 0000 0000
        * 011 000 0000
        * 016 000 0000
        *
        * 형식 통일
        * 숫자만 남기고 제거
        * 01000000000 / 010 0000 0000 / 010-0000-0000 / 010.0000.0000
        * */

        // d -> 숫자 D -> 숫자가 아님
        String mobile = num.replaceAll("\\D", "");
        // 휴대전화번호 패턴 검증
        String pattern = "^01[016]\\d{3,4}\\d{4}$"; // 정규식
        // ^01- > 처음시작이 01로 시작

        return mobile.matches(pattern);
    }
}
