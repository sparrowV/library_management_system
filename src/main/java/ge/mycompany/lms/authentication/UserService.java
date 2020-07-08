package ge.mycompany.lms.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String userName){
        return userRepository.findByUserName(userName);
    }

}
