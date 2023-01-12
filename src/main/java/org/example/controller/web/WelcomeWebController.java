package org.example.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeWebController {

    @GetMapping("/welcome")

    public String goToWelcomePage() {
        return "welcome";
    }
}
