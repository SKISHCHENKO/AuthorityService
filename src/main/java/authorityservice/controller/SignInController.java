package authorityservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/signin", "/authorize"})
public class SignInController {

    @GetMapping
    public String showSignInForm() {
        return "signin.html";
    }
}