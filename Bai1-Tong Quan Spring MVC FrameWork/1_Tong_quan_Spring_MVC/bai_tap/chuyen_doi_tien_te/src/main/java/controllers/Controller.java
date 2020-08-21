package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/Converter")
    public String getConverter(@RequestParam String usd, String rate, Model model){
        Float result = Float.parseFloat(usd)*Float.parseFloat(rate);
        model.addAttribute("result",result);
        return "Converter";
    }
    @RequestMapping("/form")
    public String showForm(){
        return "Converter";
    }
}
