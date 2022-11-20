package kata.web.dao;

import kata.web.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Override
    @Transactional
    public void add(User user) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @Transactional
    public void delete(long id) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @Transactional
    public void update(User user, long id) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User oldUser = session.get(User.class, id);
            oldUser.setName(user.getName());
            oldUser.setLastName(user.getLastName());
            oldUser.setAge(user.getAge());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List listUsers = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            listUsers = session.createQuery("FROM User").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return (List<User>) listUsers;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        User user = new User();
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            user  = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }
}
