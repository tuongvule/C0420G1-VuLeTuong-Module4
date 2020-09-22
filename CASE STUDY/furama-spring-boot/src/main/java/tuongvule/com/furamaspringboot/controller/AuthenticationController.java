//package tuongvule.com.furamaspringboot.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//public class AuthenticationController {
//
//    @GetMapping("/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
//        Cookie [] cookies = request.getCookies();
//        for (Cookie cookie : cookies){
//            if ("remember-me".equals(cookie.getName())){
//                cookie.setMaxAge(0);
//                response.addCookie(cookie);
//            }
//        }
//        return "home";
//
//    }
//}
