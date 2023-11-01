package controllers.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join() {

        return "member/join";
    }

    @PostMapping("/join")
    /*@RequestMapping(method = RequestMethod.POST, path="/join")*/
    public String joinPs() {

        System.out.println("Post");
        return "redirect:/member/login"; // 페이지 이동
    }

    @GetMapping("/login")
    public String login() {
        
        return "member/login";
    }
    
    @PostMapping("/login")
    public String loginPs() {
        
        return "member/login";
    }



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
