package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;
import service.StudentServiceImpl;

@RequestMapping("/student")
@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @RequestMapping("")
    public ModelAndView getStudentPage(){
        return new ModelAndView("student-list","students", studentService.findAll() );
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping ("/edit")
    public String editStudent(@RequestParam ("name") String name, @RequestParam("age") Integer age){
        System.out.println(name);
        System.out.println(age);
        return "redirect:/student";
    }
}
