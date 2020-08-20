package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HellController {
    @RequestMapping("/hello")
//    public String getHello(Model model, ModelMap modelMap){
//        model.addAttribute("studentName","Pham vu");
//        modelMap.addAttribute("studentAge","20");
//        return "hello";
//    }


//    public ModelAndView getHello2(Model model, ModelMap modelMap){
//        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("studentName", "Thinh");
//        modelAndView.addObject("studentAge","24");
//        return modelAndView;
//    }

    public ModelAndView getHello3(){
//        Student student1 = new Student("Thinh",20);
//        ModelAndView modelAndView = new ModelAndView("hello","student", student1.toString());
//        modelAndView.addObject("student", new Student("Thinh",20).toString());
//        return modelAndView;
       return new ModelAndView("hello", "student", new Student("Thinh",23).toString());
    }
}
