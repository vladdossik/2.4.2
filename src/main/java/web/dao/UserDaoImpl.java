package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }


    @Override
    public User getUserByName(String name) {
        return em.createQuery("select u from User u where u.name =:j_username", User.class).setParameter("j_username", name).getSingleResult();
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("SELECT p FROM User p", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> q = em.createQuery(
                "SELECT u FROM User u WHERE u.id = :id",
                User.class
        );
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        em.remove(getUser(id));
    }
}


