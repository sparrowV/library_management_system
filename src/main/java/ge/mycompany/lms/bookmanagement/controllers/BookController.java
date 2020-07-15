package ge.mycompany.lms.bookmanagement.controllers;

import ge.mycompany.lms.bookmanagement.entities.Book;
import ge.mycompany.lms.bookmanagement.services.BookService;
import ge.mycompany.lms.usermanagement.entities.LmsUserDetails;
import ge.mycompany.lms.utils.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('LIBRARIAN')")
    public ResponseEntity<?> add(@Valid @RequestBody Book book, BindingResult result) {
        ResponseEntity<?> errorsMap = MapValidationErrorService.MapValidationService(result);
        if (errorsMap != null) return errorsMap;
        Book addedBook =  bookService.add(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('LIBRARIAN')")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findBook(@RequestParam String title,@RequestParam String authorName){
        List<Book> books = bookService.findBook(title, authorName);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('LIBRARIAN')")
    public void  delete(@PathVariable Long id)
    {
        bookService.delete(id);
    }

}
