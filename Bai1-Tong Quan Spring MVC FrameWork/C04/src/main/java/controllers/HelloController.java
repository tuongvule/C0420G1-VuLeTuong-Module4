package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView getHelloPage(){
        return new ModelAndView("hello", "student", new Student("Thinh", 25));
    }

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    public ModelAndView getGoodbyePage(){
        return new ModelAndView("goodbye", "student", new Student("Thinh", 25));
    }
}
