package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getUser(long id);
    void updateUser(long id,User user);
    void deleteUser(long id);
    void addUser(User user);
    User getUserByName(String name);
}
