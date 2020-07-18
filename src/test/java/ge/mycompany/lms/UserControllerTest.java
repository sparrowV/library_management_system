package ge.mycompany.lms;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.mycompany.lms.bookmanagement.entities.Book;
import ge.mycompany.lms.usermanagement.controllers.UserController;
import ge.mycompany.lms.usermanagement.entities.User;
import ge.mycompany.lms.usermanagement.services.UserService;
import ge.mycompany.lms.usermanagement.validators.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private UserService userService;

    @Mock
    UserValidator userValidator;

    @InjectMocks
    private UserController userController;

    private JacksonTester<User> jsonUser;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(userController)
                .build();

        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldCreateNewUser() throws Exception {
        User user = new User("newuser1@gmail.com", "pwdsadasdsad", "pwdsadasdsad");
        given(userService.addUser(user))
                .willReturn(user);
        MockHttpServletResponse response = mvc.perform( post("/api/users/add").contentType(MediaType.APPLICATION_JSON).content(
                jsonUser.write(user).getJson()
        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString().equals(objectMapper.writeValueAsString(user)));
    }
}
