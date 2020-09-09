package tuongvule.com.borrowbook.service;

import tuongvule.com.borrowbook.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean borrowBook( Book book);

    void giveBookBack(Book book);
}
