package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FactorialController {

    @Autowired
    private FactorialService factorialService;

    @GetMapping("/")
    public String home() {
        return "fact";
    }
    @GetMapping("/factorial")
    public String getFactorial(@RequestParam("number") int number, Model model) {
        try {
            long result = factorialService.calculate(number);
            model.addAttribute("number", number);
            model.addAttribute("result", result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "fact";
    
    }
}