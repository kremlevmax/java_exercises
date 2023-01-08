package org.kremlevmax.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(name = "a", required = false) Integer a,
                            @RequestParam(name = "b", required = false) Integer b,
                            @RequestParam(name = "action", required = false) String action,
                            Model model) {
        String result = "Not a valid action operator";

        if (a != null && b != null) {
            switch (action) {
                case "multiplication":
                    result = String.valueOf(a) + "*" + String.valueOf(b) + "=" + String.valueOf(a*b);
                    break;
                case "addition":
                    result = String.valueOf(a) + "+" + String.valueOf(b) + "=" + String.valueOf(a+b);
                    break;
                case "subtraction":
                    result = String.valueOf(a) + "-" + String.valueOf(b) + "=" + String.valueOf(a-b);
                    break;
                case "division":
                    result = String.valueOf(a) + "/" + String.valueOf(b) + "=" + String.valueOf(a/b);
                    break;
            }
        }

        model.addAttribute("result", result);
        return "first/result";
    }
}
