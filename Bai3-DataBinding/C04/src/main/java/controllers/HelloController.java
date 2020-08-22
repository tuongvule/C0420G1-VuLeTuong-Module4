package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView getHelloPage(){
        return new ModelAndView("hello");
    }

    @GetMapping("/goodbye")
    public ModelAndView getGoodbyePage(){
        return new ModelAndView("goodbye");
    }
}
