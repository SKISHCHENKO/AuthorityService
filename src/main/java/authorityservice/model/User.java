package authorityservice.model;

import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "User name cannot be empty")
    private String user;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    // Конструкторы, геттеры и сеттеры
    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}