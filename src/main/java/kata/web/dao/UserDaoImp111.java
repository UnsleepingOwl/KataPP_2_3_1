//package kata.web.dao;
//
//import kata.web.model.User;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.TypedQuery;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserDaoImp111 implements UserDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    public void remove(User user) {
//        sessionFactory.getCurrentSession().delete(user);
//    }
//
//    /*
//    public User getUserByCarModelAndSeries(String model, int series) {
//        User user;
//        try {
//            user = (User) sessionFactory
//                    .getCurrentSession()
//                    .createQuery("from User where car.model = :model and car.series = :series")
//                    .setParameter("model", model)
//                    .setParameter("series", series)
//                    .getSingleResult();
//        } catch (Exception e) {
//            throw new RuntimeException("В базе данных нет такой комбинации модель/серийный номер");
//        }
//        return user;
//    }
//     */
//    @Override
//    public void setUserName(User user, String name) {
//
//    }
//
//    @Override
//    public void setUserLastName(User user, String lastName) {
//
//    }
//
//    @Override
//    public void setUserAge(User user, byte age) {
//
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//    @Override
//    public User getUserById(long id) {
//        return null;
//    }
//}
