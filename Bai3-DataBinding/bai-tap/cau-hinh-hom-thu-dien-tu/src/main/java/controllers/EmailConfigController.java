package controllers;

import model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emailConfig")
public class EmailConfigController {
    @GetMapping("/showEmailConfig")
    public String showEmailSetting(Model model){

        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        model.addAttribute("emailConfiguration",new EmailConfiguration());
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        return "emailConfig";
    }

    @PostMapping("/result")
    public String showResult(@ModelAttribute  EmailConfiguration emailConfiguration, Model model){
        model.addAttribute("emailConfiguration", emailConfiguration);
        return "result";
    }
}
