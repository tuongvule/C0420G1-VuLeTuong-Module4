package levunguyen.com.customermanagerspringboot.controller;

import levunguyen.com.customermanagerspringboot.model.Customer;
import levunguyen.com.customermanagerspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index", "customers", customerService.findAll());
    }
    @GetMapping("/customer/create")
    public ModelAndView create(){
        return new ModelAndView("create","customer",new Customer());
    }
    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect){
//        customer.setId((Long) (Math.random()*1000));
        customerService.save(customer);
        redirect.addFlashAttribute("success","Saved customer successfully");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public ModelAndView edit(@PathVariable Long id){
        return new ModelAndView("edit","customer",customerService.findById(id));
    }

    @PostMapping("/customer/update")
    public String update(Customer customer, RedirectAttributes redirect){
//        customerService.update(customer.getId(),customer);
        customerService.save(customer);
        redirect.addFlashAttribute("success","updated customer successfully");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        return new ModelAndView("delete","customer",customerService.findById(id));
    }
    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success","deleted customer successfully");
        return "redirect:/";
    }
    @GetMapping("customer/{id}/view")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("view", "customer",customerService.findById(id));
    }
}
