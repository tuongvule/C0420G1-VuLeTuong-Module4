package tuongvule.com.borrowbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import tuongvule.com.borrowbook.exception.BorrowBookException;
import tuongvule.com.borrowbook.exception.GiveBookBackException;

import java.util.Arrays;

@Component
@Aspect
public class AOP {
    private int count=0;
    @After(value = "execution(public * tuongvule.com.borrowbook.service.BookService.borrowBook(..)) || execution(public * tuongvule.com.borrowbook.service.BookService.giveBookBack(..))")
    public void showTotalView(JoinPoint joinPoint) {
        System.out.println("method "+ joinPoint.getSignature().getName());
        System.out.println("Count: "+ ++count);
    }
//    @AfterThrowing(pointcut = "execution(public * tuongvule.com.borrowbook.controller.BookController.*(..))")
//    public void writeLog() {
//        System.out.println("Hello");
//    }

    @AfterReturning("execution(public * tuongvule.com.borrowbook.controller.BookController.borrowBook(..))")
    public void showResultBorrow(){
        System.out.println("Cho muon thanh cong!!!");
    }
    @AfterReturning("execution(public * tuongvule.com.borrowbook.controller.BookController.giveBookBack(..))")
    public void showResultGiveBack(){
        System.out.println("Tra sach thanh cong!!!");
    }
    @AfterThrowing(value = "execution(public * tuongvule.com.borrowbook.controller.BookController.borrowBook(..) )", throwing = "e")
    public void show(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Hệ Thống] co loi xay ra khi muon sach: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
    @AfterThrowing(value = "execution(public * tuongvule.com.borrowbook.controller.BookController.giveBookBack(..) )", throwing = "e")
    public void showGiveBack(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Hệ Thống] co loi xay ra khi tra sach: %s.%s%s: %s", className, method, args, e.getMessage()));
    }


}
