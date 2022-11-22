package kata.web.dao;

import kata.web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user, Long id);
    List<User> getUsersList();
    User getUserById(Long id);
}
