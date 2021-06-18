package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getUser(int id);
    void updateUser(int id,User user);
    void deleteUser(int id);
    void addUser(User user);
    User getUserByName(String name);
}
