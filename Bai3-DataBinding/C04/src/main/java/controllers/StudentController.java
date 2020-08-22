package controllers;

import model.Course;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("")
    public ModelAndView getStudentPage(){
//        ModelAndView modelAndView = new ModelAndView("student-list");
//        List<Student> students = studentService.findAll();
//        modelAndView.addObject("students", students);
        return new ModelAndView("student", "students", studentService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("/addStudent")
    public ModelAndView addStudent(Model model){
        List<String> gender = new ArrayList<>();
        gender.add("name");
        gender.add("nu");
        model.addAttribute("gender", gender);
        return new ModelAndView("addStudent", "student", new Student());
    }

    @PostMapping("/addStudent")
    public String getAddStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Integer id, Model model ){
        Student student = studentService.findById(id);
        List<String> gender = new ArrayList<>();
        gender.add("nam");
        gender.add("nu");
        model.addAttribute("gender", gender);
        return new ModelAndView("editStudent", "student", student);
    }
    @PostMapping("/edit")
    public String getEditStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student";
    }
}
