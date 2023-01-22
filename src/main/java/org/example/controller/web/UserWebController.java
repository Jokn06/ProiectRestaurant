package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.user.UserDetailSession;
import org.example.model.user.UserRequest;
import org.example.model.user.UserRequestToLogIn;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserWebController {

    private final UserService userService;
    private final UserDetailSession userDetailSession;

    @GetMapping("/welcome")
    public String goToWelcome(Model model) {
        model.addAttribute("userLoginRequest", new UserRequest());
        return "welcome";
    }

    @PostMapping("/welcome")
    public String login(@ModelAttribute(value = "userLoginRequest") UserRequestToLogIn userRequestToLogIn, Model model) {
        try {
            userService.login(userRequestToLogIn);
            model.addAttribute("userDetailsSession", userDetailSession);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "welcome";
        }
    }
    @GetMapping("/")
    public String goToIndexPage(Model model) {
        model.addAttribute("userDetailSession", userDetailSession);
        return "/adminHomePage";
    }
}
