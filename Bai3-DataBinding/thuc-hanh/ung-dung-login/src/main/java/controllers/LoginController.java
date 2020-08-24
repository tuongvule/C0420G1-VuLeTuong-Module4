package controllers;

import DAO.UserDAO;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

@Controller
public class LoginController {
    UserDAO userDAO = new UserDAO();
    @GetMapping("/loginController")
    public ModelAndView getHome(){
        return new ModelAndView("home","login",new Login());
    }

    @PostMapping("/loginController")
    public ModelAndView login(@ModelAttribute ("login") Login login){
        User user = userDAO.checkLogin(login);
        if(user==null){
            return new ModelAndView("home","message","Login error, please login again");
        }
        return new ModelAndView("success","user",user);

    }
}
