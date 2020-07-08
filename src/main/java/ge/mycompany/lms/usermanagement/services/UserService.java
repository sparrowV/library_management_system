package ge.mycompany.lms.usermanagement.services;

import ge.mycompany.lms.usermanagement.repositories.UserRepository;
import ge.mycompany.lms.usermanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String userName){
        return userRepository.findByUserName(userName);
    }

    public User addUser(User user) {
        User existingUser = userRepository.findByUserName(user.getUserName());
        if(existingUser != null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Foo Not Found");
        }
        return null;
    }
}
