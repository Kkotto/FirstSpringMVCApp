package org.kkotto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @GetMapping("/home")
    public String printHomePage() {
        return "navigation/home";
    }

    @GetMapping("/service")
    public String printServicePage() {
        return "navigation/service";
    }
}
