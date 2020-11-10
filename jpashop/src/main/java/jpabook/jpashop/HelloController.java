package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // hello라는 url로 오면 이 controller가 호출된다
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    String str = "Hello World!";

    // remove last character(!)
    // . : matches any character except line breaks
    // $ : matches the end of the sring, or the end of a line if hte multiline flag (m) is enabled
    str = str.replaceAll(".$", "");
    System.out.println(str);


}
