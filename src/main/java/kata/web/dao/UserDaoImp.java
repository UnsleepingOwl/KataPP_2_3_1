package kata.web.dao;

import kata.web.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void update(User user, Long id) {
        User oldUser = getUserById(id);
        oldUser.setName(user.getName());
        oldUser.setLastName(user.getLastName());
        oldUser.setAge(user.getAge());
        entityManager.merge(oldUser);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return (List<User>) entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
