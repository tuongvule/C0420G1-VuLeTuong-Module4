package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class CalculatorController {
    @GetMapping("/form")
    public String getCalculator(){
        return "calculator";
    }
    @RequestMapping("/calculatorController")
    String calculator(@RequestParam String number1, @RequestParam String number2, @RequestParam String calculator, Model model){
        Double result;
        switch (calculator){
            case"Addition(+)":
                result = Double.parseDouble(number1)+Double.parseDouble(number2);
                break;
            case"Subtraction(-)":
                result = Double.parseDouble(number1)-Double.parseDouble(number2);
                break;
            case"Multiplication(X)":
                result = Double.parseDouble(number1)*Double.parseDouble(number2);
                break;
            case"Division(/)":
                result = Double.parseDouble(number1)/Double.parseDouble(number2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculator);
        }
        model.addAttribute("result",result);
        return "calculator";
    }
}
