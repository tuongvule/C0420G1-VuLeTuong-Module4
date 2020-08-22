package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionaryController")
    public String getDictionary(){
        return "dictionary";
    }
    @PostMapping("/dictionaryController")
    public String result(@RequestParam String key, Model model){
        Map<String, String> listDictionary = new HashMap<>();
        listDictionary.put("hello","xin chao");
        listDictionary.put("good bye","tam biet");
        listDictionary.put("good night","chuc ngu ngon");
        listDictionary.put("good morning","chao buoi sang");
        listDictionary.put("go","di");
        listDictionary.put("love","yeu");
        String result ="" ;
        if(listDictionary.containsKey(key)) {
            result = listDictionary.get(key);
        }else {
            result = "not found";
        }
        model.addAttribute("result", result);
        return "dictionary";
    }
}
