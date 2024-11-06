package authorityservice.service;

import authorityservice.authorities.Authorities;
import authorityservice.exception.InvalidCredentials;
import authorityservice.exception.UnauthorizedUser;
import authorityservice.model.User;
import authorityservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (user.getUser() == null || user.getPassword() == null) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (userAuthorities == null || userAuthorities.isEmpty()) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }
}