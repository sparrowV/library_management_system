package ge.mycompany.lms.bookmanagement.controllers;

import ge.mycompany.lms.bookmanagement.entities.Book;
import ge.mycompany.lms.bookmanagement.services.BookService;
import ge.mycompany.lms.utils.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Book book, BindingResult result) {
        ResponseEntity<?> errorsMap = MapValidationErrorService.MapValidationService(result);
        if (errorsMap != null) return errorsMap;
        Book addedBook =  bookService.add(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }
}
