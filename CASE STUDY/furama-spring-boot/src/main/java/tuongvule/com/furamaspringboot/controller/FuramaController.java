package tuongvule.com.furamaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuongvule.com.furamaspringboot.entity.AppUser;
import tuongvule.com.furamaspringboot.entity.UserRole;
import tuongvule.com.furamaspringboot.model.*;
import tuongvule.com.furamaspringboot.repository.AppRoleRepository;
import tuongvule.com.furamaspringboot.repository.AppUserRepository;
import tuongvule.com.furamaspringboot.repository.UserRoleRepository;
import tuongvule.com.furamaspringboot.service.*;
import tuongvule.com.furamaspringboot.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("listCustomerUpdate")

public class FuramaController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    /* add listCustomerUpdate Session in model attribute */

    @ModelAttribute("listCustomerUpdate")
    public List<Customer> setUpListCustomer() {
        return new ArrayList<>();
    }


    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
//        return "welcomePage";
        return "home";

    }

//         Manipulation with Customer ---------------------------------------------------------------------------------------
    @GetMapping("/customer")
    public ModelAndView listCustomer(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
//        Pageable pageable1 = PageRequest.of(0, 2);
        Page<Customer> customers = customerService.findAll(search, pageable);
        ModelAndView modelAndView = new ModelAndView("listCustomer", "customers", customers);
        if (customers.isEmpty()) {
            modelAndView.addObject("message", "Not found customer in DB");
        } else {
            modelAndView.addObject("search", search);//để hiển thị lại trên ô tìm kiếm
        }
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView viewCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("createCustomer", "customer", new Customer());
        modelAndView.addObject("customerTypeList", customerTypeService.findAllCustomerType());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public String saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
            return "createCustomer";
        }

        attributes.addFlashAttribute("message", "created customer: " + customer.getName() + " successfully");
        customerService.save(customer);

        return "redirect:/customer";
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView editCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("editCustomer", "customer", customer);
            modelAndView.addObject("customerTypeList", customerTypeList);
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/customer/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes,
                                 @ModelAttribute("listCustomerUpdate") List<Customer> listCustomerUpdate ) {
        redirectAttributes.addFlashAttribute("message", "updated customer successfully");
        customerService.save(customer);
        listCustomerUpdate.add(customer);
        return "redirect:/customer";
    }

//    show listCustomerUpdate session

    @GetMapping("/showSessionListCustomerUpdate")
    public ModelAndView showSessionListCustomerUpdate(@ModelAttribute("listCustomerUpdate") List<Customer> listCustomerUpdate ){
        return new ModelAndView("showSessionListCustomerUpdate", "listCustomerUpdate", listCustomerUpdate );
    }

    @GetMapping("/customer/{id}/delete")
    public ModelAndView showDeleteCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("deleteCustomer", "customer", customer);
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "deleted customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/customer/{id}/view")
    public ModelAndView viewCustomer(@PathVariable("id") Long id) {
        return new ModelAndView("viewCustomer", "customer", customerService.findById(id));
    }

    //     Manipulation with Service -----------------------------------------------------------------------------------
    @GetMapping("/service")
    public ModelAndView listService(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
        Page<Service> services = serviceService.findAllService(search, pageable);
        ModelAndView modelAndView = new ModelAndView("listService", "services", services);
        if (services.isEmpty()) {
            modelAndView.addObject("message", "Not found customer in DB");
            return modelAndView;
        } else {
            modelAndView.addObject("search", search);//để hiển thị lại trên ô tìm kiếm
            return modelAndView;
        }
    }

    @GetMapping("/service/create")
    public ModelAndView viewCreateService() {
        ModelAndView modelAndView = new ModelAndView("createService", "service", new Service());
        modelAndView.addObject("serviceTypeList", serviceTypeService.findAllServiceType());
        modelAndView.addObject("rentTypeList", rentTypeService.findAllRentType());
        return modelAndView;
    }

    @PostMapping("/service/create")
    public String saveService(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult, RedirectAttributes attributes,
                               Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("serviceTypeList", serviceTypeService.findAllServiceType());
            model.addAttribute("rentTypeList", rentTypeService.findAllRentType());
            return "createService";
        }
        attributes.addFlashAttribute("message", "created customer: " + service.getNameService() + " successfully");
        serviceService.save(service);
        return "redirect:/customer";
    }

    @GetMapping("/service/{id}/edit")
    public ModelAndView editService(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        List<ServiceType> serviceTypeList = serviceTypeService.findAllServiceType();
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        if (service != null) {
            ModelAndView modelAndView = new ModelAndView("editService", "service", service);
            modelAndView.addObject("serviceTypeList", serviceTypeList);
            modelAndView.addObject("rentTypeList", rentTypeList);
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/service/update")
    public String updateService(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "updated customer successfully");
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/service/{id}/delete")
    public ModelAndView showDeleteService(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service != null) {
            return new ModelAndView("deleteService", "service", service);
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/service/delete")
    public String deleteService(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        customerService.remove(service.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted customer successfully");
        return "redirect:/service";
    }

    @GetMapping("/service/{id}/view")
    public ModelAndView viewService(@PathVariable("id") Long id) {
        return new ModelAndView("viewService", "service", serviceService.findById(id));
    }

    //     Manipulation with Contract -----------------------------------------------------------------------------------
    @GetMapping("/contract")
    public ModelAndView listContract(@RequestParam(value = "search", defaultValue = "") String search, @PageableDefault(2) Pageable pageable) {
        Page<Contract> contracts = contractService.findContractByAll(search, pageable);
        ModelAndView modelAndView = new ModelAndView("listContract", "contracts", contracts);
        if (contracts.isEmpty()) {
            modelAndView.addObject("message", "Not found in database");
        }
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/contract/{id}/create")
    public ModelAndView createContractForm(@PathVariable("id") Long id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("createContract", "contract", new Contract());
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("serviceList", serviceService.findAllService("", pageable));
        return modelAndView;
    }

    @PostMapping("/contract/create")
    public String saveContract(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                               RedirectAttributes attributes, Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("serviceList", serviceService.findAllService("",Pageable.unpaged()));
            return "createContract";
        }
        attributes.addFlashAttribute("message", "Created contract with Id: " + contract.getId() + " successfully");
        contractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("/contract/{id}/edit")
    public ModelAndView editContractForm(@PathVariable("id") Long id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("editContract", "contract", contractService.findById(id));
        modelAndView.addObject("serviceList", serviceService.findAllService("", pageable));
        return modelAndView;
    }

    @PostMapping("/contract/update")
    public String updateContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "updated customer successfully");
        contractService.save(contract);
        return "redirect:/contract";
    }

//   1.	Sử dụng cookie để lưu lại những lần user xóa hợp đồng.-------------------------------------------------------

    @GetMapping("/contract/{id}/delete")
    public ModelAndView deleteContract(@PathVariable("id") Long id, @CookieValue(name = "contractCookie", defaultValue = "") String contractCookie, HttpServletResponse response ) {
        Contract contract = contractService.findById(id);

        contractCookie += ":" + contract.getId() + ":" + contract.getCustomer().getName() + ":" + contract.getStartDate();

        Cookie cookie=new Cookie("contractCookie",contractCookie);
        cookie.setMaxAge(600);
        cookie.setPath("/");

        response.addCookie(cookie);// trả về trên client lưu vào
        if (contract != null) {
            return new ModelAndView("deleteContract", "contract", contract);
        } else {
            return new ModelAndView("error.404");
        }
    }

    @GetMapping("/getCookie")
    public String getCookie(@CookieValue (name = "contractCookie", defaultValue = "") String contractCookie, Model model){
        model.addAttribute("contractCookie", contractCookie);
        return "home";
    }

//    --------------------------------------------------------------------------------------------------------------------
    @PostMapping("contract/delete")
    public String deleteContract(@ModelAttribute("contract") Contract contract) {
        contractService.remove(contract.getId());
        return "redirect:/contract";
    }

    @GetMapping("contract/{id}/view")
    public ModelAndView viewContract(@PathVariable("id") Long id) {
        return new ModelAndView("viewContract", "contract", contractService.findById(id));
    }

    //     Manipulation with Contract Detail ---------------------------------------------------------------------------
    @GetMapping("/contractDetail/{id}/create")
    public ModelAndView createContractDetailForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("createContractDetail", "contractDetail", new ContractDetail());
        modelAndView.addObject("attachServiceList",attachServiceService.findAllAttachService());
        modelAndView.addObject("contract", contractService.findById(id));
        return modelAndView;
    }

    @PostMapping("/contractDetail/create")
    public String saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "created contractDetail with: " + contractDetail.toString() + " successfully");
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }

    //     Show list of customers using services at resort ---------------------------------------------------------------------------

    @GetMapping("/customers-use-service")
    public ModelAndView customerUseService(@RequestParam(value = "search", defaultValue = "") String search,Pageable pageable){
        Page<Contract> contracts = contractService.findContractByAll(search, pageable);
        ModelAndView modelAndView =  new ModelAndView("listCustomersUseService", "contracts", contracts);
        if (contracts.isEmpty()) {
            modelAndView.addObject("message", "Not found in database");
        }
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    //     Show list of customers using services at resort ---------------------------------------------------------------------------
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
//    Show all customers are using services at Furama and Total Money
    @RequestMapping("/customerAndTotal")
    public ModelAndView showCustomerAndTotal(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("listCustomerAndTotal", "contracts", contractService.findCustomerAndTotal(pageable) );
        return modelAndView;
    }


//    Register New User
    @GetMapping("/register")
        public ModelAndView viewRegister(Model model) {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String viewRegister(@RequestParam("username") String username, @RequestParam("password") String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(password);
        AppUser appUser = new AppUser();

        appUser.setUserName(username);
        appUser.setEncrytedPassword(hashPassword);
        appUserRepository.save(appUser);

        UserRole userRole = new UserRole();
        userRole.setId(appUser.getUserId());
        userRole.setAppRole(appRoleRepository.findByRoleName("ROLE_USER"));
        userRole.setAppUser(appUserRepository.findByUserName(appUser.getUserName()));
        userRoleRepository.save(userRole);

        return "redirect:/";

//        user.setRole(roleRepository.findByRoleName("ROLE_USER"));
//        userRepository.save(user);
    }

//    Sign Out


}
