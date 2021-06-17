package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
}
