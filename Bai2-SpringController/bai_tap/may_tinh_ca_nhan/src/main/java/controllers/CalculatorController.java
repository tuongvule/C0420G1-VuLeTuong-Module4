package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/form")
    public String getForm(){
        return "calculator";
    }
    @RequestMapping("/calculator")
    public String addition(@RequestParam String num1, String num2,String calculate, Model model){
        double result = 0;
        switch (calculate){
            case "Addition(+)":
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case "Subtraction(-)":
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case "Multiplication(x)":
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case "Division(/)":
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                break;
        }
        model.addAttribute("result",result);
        return "calculator";
    }
}
