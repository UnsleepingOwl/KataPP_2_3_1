package kata.web.dao;

import kata.web.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
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
    @Transactional
    public void delete(long id) {
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
    @Transactional
    public void update(User user, long id) {
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
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List listUsers = null;
        try {
            listUsers = entityManager.createQuery("FROM User").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return (List<User>) listUsers;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
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
