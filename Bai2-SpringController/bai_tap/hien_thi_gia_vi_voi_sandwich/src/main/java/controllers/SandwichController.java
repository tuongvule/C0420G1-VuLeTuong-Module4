package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/sandwichForm")
    public String form(){
        return "sandwich";
    }
    @RequestMapping("/save")
    public String save(@RequestParam String lettuce, String tomato, String mustard, String sprouts, Model model){
        model.addAttribute("lettuce",lettuce);
        model.addAttribute("tomato",tomato);
        model.addAttribute("mustard",mustard);
        model.addAttribute("sprouts",sprouts);
        return "finish";
    }
}
