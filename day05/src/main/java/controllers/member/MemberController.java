package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin join) {
        
        // 비어있는 커맨드 객체를 만들어야 오류가 발생하지 않는다 (GET방식일 때)
        /*RequestJoin requestJoin = new RequestJoin();
        model.addAttribute("requestJoin", requestJoin);*/

        return "member/join";
    }

    @PostMapping("/join")
    /*@RequestMapping(method = RequestMethod.POST, path="/join")*/
    public String joinPs(@Valid  RequestJoin join, Errors errors) {
                        // 요청 메서드의 매개변수로 정의하면 알아서 주입. 클래스명에서 앞자가 소문자로 변경된 형태로 사용
                        // 커맨드 객체 뒤에 Errors errors 객체를 입력해야 정상 작동 한다

        //model.addAttribute("requestJoin", join);

        //System.out.println(join);
        //return "redirect:/member/login"; // 페이지 이동

       // System.out.println("데이터 확인: " + join);

        //joinValidator.validate(join, errors);

        if (errors.hasErrors()) {

            // 검증 실패시 유입
            return "member/join";
        }

        // 검증 성공 -> 회원가입 처리
        joinService.join(join);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form, @CookieValue(name="saveId", required = false) String userId) {

        if (userId != null) {
            //form.userId(userId);
        }

        System.out.println(userId);
        
        return "member/login";
    }
    
    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors, HttpSession session) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "member/login";
        }

        // 유효성 검사 성공 -> 로그인 처리
        loginService.login(form);

        return "redirect:/";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/member/login";

    }

    /*
    @InitBinder // 컨트롤 범위내에서 공통적인 Validator 설정
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);

    }
    */


    /*@GetMapping("/member/join")
    public String join(Model model) {

        String[] addCss = {"member/test1","member/test2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원가입");
        

        return "member/join";
    }*/

    /*@Autowired
    private HttpServletRequest request;

    @GetMapping("/member/login")
    public String login(RequestLogin form, HttpServletResponse response) {

        System.out.println(form);
        System.out.println(response);
        System.out.println(request.getParameter("userId"));
        System.out.println(request.getParameter("userPw"));
        System.out.println(request.getParameter("saveId"));

        return "member/login";
    }*/

    /*@GetMapping("/member/login")
    public String login(*//*RequestLogin form,*//* Model model) {

        *//*model.addAttribute("message", "안녕하세요");*//*
        model.addAttribute("userId", "user99");
        model.addAttribute("userPw", "비밀번호");

        return "member/login"; // login.html
    }

    @GetMapping("/member/info")
    public String info(Model model) {

        Member member = Member.builder()
                .userNo(1L)
                .userId("<h1>user01</h1>")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("010-0000-0000")
                .build();

        model.addAttribute("member", member);

        return "member/info";
    }
    @GetMapping("/member/list")
    public String members(Model model) {

        List<Member> members = IntStream.rangeClosed(1, 10).mapToObj(this::addMember).toList();
        model.addAttribute("members", members);

        return "member/list";
    }

    private Member addMember(int i) {

        return Member.builder()
                .userNo(i * 10000)
                .userId("user" + i)
                .userPw("123456")
                .userNm("사용자" + i)
                .email("user" + i + "@test.org")
                .mobile("010-0000-0000")
                .regDt(LocalDateTime.now())
                .build();
    }*/


}
