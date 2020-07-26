package ge.mycompany.lms.bookmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "books")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="bookIdSeq",sequenceName = "books_id_seq",allocationSize = 1)
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

    @Column(name="author_name")
    @NotBlank(message = "author name should not be empty")
    private String authorName;

    @Column(name="quantity")
    @Min(value = 1,message = "quantity must be greater than 0")
    @NotNull(message = "quantity should not be empty")
    private Integer quantity;



}
