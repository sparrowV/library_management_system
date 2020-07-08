package ge.mycompany.lms.usermanagement.services;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import ge.mycompany.lms.usermanagement.exceptions.UsernameAlreadyExistsException;
import ge.mycompany.lms.usermanagement.repositories.UserRepository;
import ge.mycompany.lms.usermanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findUserByUsername(String userName){
        return userRepository.findByUsername(userName);
    }

    public User addUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            throw new UsernameAlreadyExistsException(String.format("username %s already exists", user.getUsername()));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
