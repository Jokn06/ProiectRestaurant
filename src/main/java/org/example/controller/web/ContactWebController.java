package org.example.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactWebController {

    @GetMapping("/contact")
    public String gotoContactPage() {
        return "contact";
    }
}
