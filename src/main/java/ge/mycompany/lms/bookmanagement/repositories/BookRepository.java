package ge.mycompany.lms.bookmanagement.repositories;

import ge.mycompany.lms.bookmanagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByTitle(String title);

}
