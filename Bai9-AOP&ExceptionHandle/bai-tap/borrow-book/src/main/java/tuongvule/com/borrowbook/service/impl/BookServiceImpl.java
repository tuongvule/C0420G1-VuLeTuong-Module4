package tuongvule.com.borrowbook.service.impl;

import org.springframework.stereotype.Service;
import tuongvule.com.borrowbook.model.Book;
import tuongvule.com.borrowbook.service.BookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookServiceImpl implements BookService {
    private static Map<Integer,Book> books = new HashMap<>();
    static {
        books.put(1,new Book(1,"Nha lanh dao khong chuc danh",4));
        books.put(2,new Book(2,"Bi mat su lao hoa nguoc cua loai ong",3));
        books.put(3,new Book(3,"quan go di len",5));
        books.put(4,new Book(4,"bi mat sieu tri nho",2));
        books.put(5,new Book(5,"tren duong bang",6));
    }
    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBookById(int id) {
        Book book = books.get(id);
        if(book!=null){
            return book;
        }
        return null;
    }

    @Override
    public boolean borrowBook(Book book) {
      Book temp = books.get(book.getId());
      if(temp.getAmount()==0){
          return false;
      }else {
          temp.setAmount(temp.getAmount()-1);
          return true;
      }

    }

    @Override
    public void giveBookBack(Book book) {
        Book temp = books.get(book.getId());
        if(temp!=null){
            temp.setAmount(temp.getAmount()+1);
        }
    }
}
