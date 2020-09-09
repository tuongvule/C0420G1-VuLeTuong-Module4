package tuongvule.com.borrowbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tuongvule.com.borrowbook.exception.BorrowBookException;
import tuongvule.com.borrowbook.exception.GiveBookBackException;
import tuongvule.com.borrowbook.model.Book;
import tuongvule.com.borrowbook.service.BookService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController {
    private Map<Integer,Book> bookMap = new HashMap<>();
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView showBookList(){
        return new ModelAndView("list", "books",bookService.getAllBooks());
    }
    @GetMapping("/borrowBook/{id}")
    public ModelAndView showBorrowBookForm(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        Random rand = new Random();
        int random= rand.nextInt(99999-10000) + 10000;
        if (book==null){
            return new ModelAndView("error");
        }else {
            ModelAndView modelAndView= new ModelAndView("borrowBook","book",book);
            modelAndView.addObject("random",random);

            return modelAndView;
        }
    }
    @PostMapping("/borrowBook/{random}")
    public ModelAndView borrowBook(@PathVariable("random") int random, @ModelAttribute("book") Book book) throws BorrowBookException{
        if (bookService.borrowBook(book)){
            bookMap.put(random,book);
            System.out.println(random);
            return new ModelAndView("list","books",bookService.getAllBooks());
        }
         throw  new BorrowBookException();
    }

    @GetMapping("/showGiveBookBack")
    public ModelAndView showGiveBookBack(){
        return new ModelAndView("showGiveBookBack");
    }
    @PostMapping("/giveBookBack")
    public ModelAndView giveBookBack(@RequestParam("random") Integer random)throws GiveBookBackException{
        if(bookMap.containsKey(random)){
            bookService.giveBookBack(bookMap.get(random));
            bookMap.remove(random);
            return new ModelAndView("list","books", bookService.getAllBooks());
        }
        throw new GiveBookBackException();
    }
    @ExceptionHandler(BorrowBookException.class)
    public ModelAndView showInputNotAcceptable(){return new ModelAndView("error");}
    @ExceptionHandler(GiveBookBackException.class)
    public ModelAndView showErrorGiveBookBack(){
        return new ModelAndView("errorGiveBookBack");
    }
}
