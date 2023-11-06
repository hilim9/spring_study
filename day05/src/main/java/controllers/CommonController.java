package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers") // 공통적인 에러페이지 한정
public class CommonController {

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {
        e.printStackTrace(); // 오류 출력

        model.addAttribute("message", e.getMessage());

        return "error/common";
    }
}
