package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/form")
    public String showForm(){
        return "dictionary";
    }
    @RequestMapping("/dictionary")
    public String getDictionary(@RequestParam String Eng, Model model){
        Map<String,String> list = new HashMap<>();
        list.put("hello","xin chào");
        list.put("goodbye","tạm biệt");
        list.put("name","tên");
        String result = "";
        if (list.containsKey(Eng)){
            result = list.get(Eng);
        }else {
            result = "Not Found";
        }
        model.addAttribute("result",result);
        return "dictionary";
    }
}
