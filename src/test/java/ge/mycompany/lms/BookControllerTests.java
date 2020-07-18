package ge.mycompany.lms;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.mycompany.lms.bookmanagement.controllers.BookController;
import ge.mycompany.lms.bookmanagement.entities.Book;
import ge.mycompany.lms.bookmanagement.repositories.BookRepository;
import ge.mycompany.lms.bookmanagement.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mvc;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private JacksonTester<List<Book>> jsonBook;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(bookController)
                .build();
    }


    @Test
    public void canRetrieveAll() throws Exception{
        List<Book> books = new ArrayList<Book>(){
            {
                add(new Book(1L, "title1", "location1","authorname1",10));
                add(new Book(2L, "title2", "location2","authorname2",10));
                add(new Book(3L, "title3", "location3","authorname3",10));
                add(new Book(4L, "title4", "location4","authorname4",10));
                add(new Book(5L, "title5", "location5","authorname5",10));

            }
        };

        given(bookService.findAll())
                .willReturn(books);

        MockHttpServletResponse response = mvc.perform(
                get("/api/books/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonBook.write(books).getJson()
        );
    }

    @Test
    public void canRetrieveByTitleAndAuthorName() throws Exception {
        List<Book> books = new ArrayList<Book>(){
            {
             add(new Book(1L, "title", "location","authorname",10));
            }
        };

        given(bookService.findBook("title","authorName"))
                .willReturn(books);

        MockHttpServletResponse response = mvc.perform(
                get("/api/books")
                        .param("title","title")
                        .param("authorName","authorName")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonBook.write(new ArrayList<Book>(){
                    {
                        add(new Book(1L, "title", "location","authorname",10));
;                    }
                }).getJson()
        );
    }

}
