package Seminar5OOP.personal.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String createUser(User user);
    void saveUsers(List<User> users);
    
}
