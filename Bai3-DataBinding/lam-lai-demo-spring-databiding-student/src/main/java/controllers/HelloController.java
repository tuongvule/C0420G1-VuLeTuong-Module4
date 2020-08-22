package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView getHello(){
        return new ModelAndView("hello", "student",new Student(1,"Thinh", 25,"Nam"));
    }

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    public ModelAndView getGoodbye(){
        return new ModelAndView("goodbye", "student", new Student(2, "Thinh", 24, "Nam"));
    }
}
