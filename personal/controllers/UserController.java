package Seminar5OOP.personal.controllers;

import Seminar5OOP.personal.model.Repository;
import Seminar5OOP.personal.model.User;
import Seminar5OOP.personal.views.Validation;

import java.util.List;

public class UserController {
    private final Repository repository;
    private final Validation validator;

    public UserController(Repository repository, Validation validator)
    {
        this.validator = validator;
        this.repository = repository;
    }

    public void saveUser(User user) {
        validator.validateUser(user);
        repository.createUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        return userSearch(userId, users);
    }

    private static User userSearch(String userId, List<User> users) throws ClassNotFoundException{
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new ClassNotFoundException("User not found");
    }

    public List<User> readAllUsers(){
        return repository.getAllUsers();
    }

    public void updateUser(String userId, User newUser) throws Exception {
        validator.validateUser(newUser);
        List<User> users = repository.getAllUsers();
        User user = userSearch(userId,users);
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhone(newUser.getPhone());
        repository.saveUsers(users);
    }

    public void deleteUser(String userId){
        List<User> users = readAllUsers();
        users.removeIf(item -> item.getId().equals(userId));
        repository.saveUsers(users);
    }
}