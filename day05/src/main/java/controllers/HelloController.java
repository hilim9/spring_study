package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "nm", defaultValue = "이름없음") String name, int num1, @RequestParam("ag") boolean agree) {

        System.out.printf("name=%s%n, num1=%d%n agree=%s%n",name, num1, agree);

        return "hello";

    }

    /*@GetMapping("/hello")
    public ModelAndView hello() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "반갑습니다"); // 데이터
        mv.setViewName("hello"); // 경로

        return mv;

    }*/

}
