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
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(getUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(User user, Long id) {
        try {
            User oldUser = getUserById(id);
            oldUser.setName(user.getName());
            oldUser.setLastName(user.getLastName());
            oldUser.setAge(user.getAge());
            entityManager.merge(oldUser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User> listUsers = null;
        try {
            listUsers = entityManager.createQuery("FROM User").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return listUsers;
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        try {
            user = entityManager.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return user;
    }
}
