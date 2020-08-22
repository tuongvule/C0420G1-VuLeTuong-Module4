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

    @RequestMapping("")
    public ModelAndView getStudentPage(){
        return new ModelAndView("student-list","students", studentService.findAll() );
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return "redirect:/student";
    }

//    @GetMapping ("/edit")
//    public String editStudent(){
//        return "redirect:/student";
//    }

//    @GetMapping ("/addStudent")
//    public String addStudent(){
//        return "addStudent";
//    }

//    @PostMapping("/addStudent")
//    public String getAddStudentPage(@RequestParam Integer id
//            , @RequestParam String name
//            ,@RequestParam Integer age
//            ,@RequestParam String gender){
//        studentService.save(new Student(id, name, age,gender));
//        return "redirect:/student";
//    }
    @GetMapping ("/addStudent")
    public ModelAndView addStudent(Model model){
        List<String> gender = new ArrayList<>();
        gender.add("Nam");
        gender.add("Nu");
        model.addAttribute("gender",gender);
        return new ModelAndView("addStudent","student",new Student());
    }
    @PostMapping("/addStudent")
    public String getAddPage(@ModelAttribute Student student){

        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/editStudent/{id}")
    public ModelAndView getEditPage( Model model,@PathVariable Integer id){
        List<String> gender = new ArrayList<>();
        gender.add("Nam");
        gender.add("Nu");
        model.addAttribute("gender",gender);
       return new ModelAndView("editStudent","student",studentService.findById(id));
    }

    @PostMapping("/editStudent")
    public String editStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student";
    }


}
