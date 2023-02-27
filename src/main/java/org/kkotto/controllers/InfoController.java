package org.kkotto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/info")
public class InfoController {
    @GetMapping("/")
    public String printInfoPage() {
        return "info/info";
    }

    @GetMapping("/calculator")
    public String printCalculationPage(@RequestParam("first") int firstValue,
                                       @RequestParam("second") int secondValue,
                                       @RequestParam("action") String action,
                                       Model model) {
        String message = firstValue + " " + action + " " + secondValue + " = ";
        switch (action) {
            case "addition":
                message += String.valueOf(firstValue + secondValue);
                break;
            case "subtraction":
                message += String.valueOf(firstValue - secondValue);
                break;
            case "multiplication":
                message += String.valueOf(firstValue * secondValue);
                break;
            case "division":
                message += String.valueOf(firstValue / (double) secondValue);
                break;
            default:
                message += "no info";
        }
        model.addAttribute("result", message);
        return "info/calculate";
    }
}
