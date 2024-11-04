package authorityservice.repository;

import authorityservice.authorities.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    Map<String, String> authorities = new ConcurrentHashMap<>();
    Map<String, List<Authorities>> permits = new ConcurrentHashMap<>();

    public UserRepository() {

        // Инициализация authorities
        authorities.put("admin", "12345");
        authorities.put("guest", "11111");
        authorities.put("user", "qwerty");

        // Инициализация permits
        permits.put("admin", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        permits.put("guest", List.of(Authorities.READ));
        permits.put("user", Arrays.asList(Authorities.READ, Authorities.WRITE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        user = user.replace("<", "").replace(">", "");
        password = password.replace("<", "").replace(">", "");

        String storedPassword = authorities.get(user);

        if (storedPassword == null) {
            return Collections.emptyList();
        }

        if (!storedPassword.equals(password)) {
            return Collections.emptyList();
        }

        return permits.get(user);
    }
}