package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    List<User> listUsers();

    User getUser(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

    void addUser(User user);
}
