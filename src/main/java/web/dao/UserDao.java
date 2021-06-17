package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    List<User> listUsers();

    User getUser(long id);

    void updateUser(long id, User user);

    void deleteUser(long id);

    void addUser(User user);
}
