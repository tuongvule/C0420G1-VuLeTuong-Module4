package cg.wbd.grandemonstration.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
@Aspect
public class Logger {
    public void error(){
        System.out.println("[CMS] ERROR!");
    }


//    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.findAll(..))")
//    public void log() {
//    }

//    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))")
//    public void log() {
//    }

//    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))", throwing = "e")
//    public void log(Exception e) {
//        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
//    }

    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.*.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
