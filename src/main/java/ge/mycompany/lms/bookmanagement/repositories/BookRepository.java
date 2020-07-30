package ge.mycompany.lms.bookmanagement.repositories;

import ge.mycompany.lms.bookmanagement.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByTitle(String title);

    List<Book> findByTitleOrAuthorName(String title, String authorName);

    Page<Book> findByTitleOrAuthorName(String title, String authorName, Pageable pageable);
}
