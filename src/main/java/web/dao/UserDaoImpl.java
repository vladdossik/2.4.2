package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;



    @Override
    public User getUserByName(String name) {
        return null;
    }
}

