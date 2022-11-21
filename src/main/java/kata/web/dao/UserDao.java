package kata.web.dao;

import kata.web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(Long id);
    void update(User user, Long id);
    List<User> listUsers();
    User getUserById(Long id);
}
