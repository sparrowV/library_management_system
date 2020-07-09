package ge.mycompany.lms.bookmanagement.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "books")
@Data
@NoArgsConstructor
@SequenceGenerator(name="bookIdSeq",sequenceName = "books_id_seq")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookIdSeq")
    private Long id;

    @Column(name="title")
    @NotBlank(message = "title should not be empty")
    private String title;

    @Column(name="location")
    @NotBlank(message = "location should not be empty")
    private String location;

    @Column(name="authorName")
    @NotBlank(message = "author name should not be empty")
    private String authorName;

    @Column(name="count")
    @NotBlank
    @Size(min=1,message = "count of the books must be greater than 1")
    private Integer count;


}
