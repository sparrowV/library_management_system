package ge.mycompany.lms.bookmanagement.services;

import ge.mycompany.lms.bookmanagement.entities.Book;
import ge.mycompany.lms.bookmanagement.repositories.BookRepository;
import ge.mycompany.lms.usermanagement.entities.LmsUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book add(Book givenBook) {
        Book existingBook = findByTitle(givenBook.getTitle());
        if (existingBook != null) {
            existingBook.setQuantity(existingBook.getQuantity() + givenBook.getQuantity());
            return bookRepository.save(existingBook);
        }
        return bookRepository.save(givenBook);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findBook(String title, String authorName) {
        return bookRepository.findByTitleOrAuthorName(title, authorName);

    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }


    public Page<Book> getBooksByPage(String title, String authorName, int pageNum, int size) {
        PageRequest pageReq = PageRequest.of(pageNum, size);
        return bookRepository.findByTitleOrAuthorName(title,authorName,pageReq);
    }
}
