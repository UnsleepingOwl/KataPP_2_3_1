package kata.web.dao;

import kata.web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(long id);
    void update(User user, long id);
    List<User> listUsers();
    User getUserById(long id);
}
