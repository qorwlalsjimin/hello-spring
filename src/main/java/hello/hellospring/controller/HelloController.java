package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // /hello를 치면 이 메서드를 실행시켜줌
    public String hello(Model model){
        model.addAttribute("data", "spring!"); //model(data:hello!)
        return "hello"; // hello.html로 이동 (templates/hello.html)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name,
                           //name = "name"의 "name"으로 값(GET 방식)을 입력하게 한다
                           //String name의 name으로 웹주소의 값을 받아와 java에서 사용하게 한다
                           Model model){

        //model에 담으면 View에서 랜더링할때 쓰인다
        //html에서 name이라는 attributeName으로 value를 불러옴
        model.addAttribute("name", name); //key, value

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body에 이 데이터를 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        //http://localhost:8080/hello-api?name=strp
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private  String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
