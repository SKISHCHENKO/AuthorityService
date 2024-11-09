package authorityservice.controller;
import authorityservice.authorities.Authorities;
import authorityservice.model.User;
import authorityservice.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authorize")
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/signin")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

}