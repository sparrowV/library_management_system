package ge.mycompany.lms.usermanagement.controllers;

import ge.mycompany.lms.usermanagement.entities.User;
import ge.mycompany.lms.usermanagement.services.UserService;
import ge.mycompany.lms.usermanagement.validators.UserValidator;
import ge.mycompany.lms.utils.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/users")
@RestController
public class UserController {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody  User user, BindingResult result){
        userValidator.validate(user,result);
        ResponseEntity<?> errorMap = MapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

}
