package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class RoleDaoImpl {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    public Role getRoleById(int id) {
        TypedQuery<Role> q = em.createQuery(
                "SELECT u FROM Role u WHERE u.id = :id",
                Role.class
        );
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }
}

