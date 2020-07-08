package ge.mycompany.lms.usermanagement.services;

import ge.mycompany.lms.usermanagement.entities.LmsUserDetails;
import ge.mycompany.lms.usermanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LmsUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User with username=%s does not exist",username));
        }
        return new LmsUserDetails(user);
    }
}
