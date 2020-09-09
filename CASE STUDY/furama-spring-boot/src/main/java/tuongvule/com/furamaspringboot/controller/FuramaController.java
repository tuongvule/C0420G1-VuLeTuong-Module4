package tuongvule.com.furamaspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {
    @GetMapping("/")
    public String getFormHome(){
        return "home";
    }
}
