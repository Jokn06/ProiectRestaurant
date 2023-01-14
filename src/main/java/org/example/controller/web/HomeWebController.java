package org.example.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {
    @GetMapping("/home")
    public String gotoHomePage() {
        return "home";
    }
}
