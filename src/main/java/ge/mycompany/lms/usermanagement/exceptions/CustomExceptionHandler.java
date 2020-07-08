package ge.mycompany.lms.usermanagement.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(UsernameAlreadyExistsException ex, WebRequest request){
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode childNode = mapper.createObjectNode();
        childNode.put("username", ex.getMessage());
        return new ResponseEntity(childNode, HttpStatus.BAD_REQUEST);
    }


}
