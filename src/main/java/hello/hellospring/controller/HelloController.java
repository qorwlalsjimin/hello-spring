package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // /hello를 치면 이 메서드를 실행시켜줌
    public String hello(Model model){
        model.addAttribute("data", "spring!"); //model(data:hello!)
        return "hello"; // hello.html로 이동 (templates/hello.html)
    }
}
