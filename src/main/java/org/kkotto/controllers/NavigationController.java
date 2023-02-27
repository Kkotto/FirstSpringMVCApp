package org.kkotto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigationController {
    @GetMapping("/home")
    public String printHomePage(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "surname", required = false) String surname,
                                Model model) {
        StringBuilder message = new StringBuilder("Hello, ");
        message.append(name == null ? "mr" : name);
        message.append(" ");
        message.append(surname == null ? "Noname" : surname);
        model.addAttribute("message", message);
        return "navigation/home";
    }

    @GetMapping("/service")
    public String printServicePage() {
        return "navigation/service";
    }
}
