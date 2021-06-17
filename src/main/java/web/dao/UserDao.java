package web.dao;

import jm.security.example.model.User;

public interface UserDao {
    User getUserByName(String name);
}
