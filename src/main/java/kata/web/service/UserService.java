package kata.web.service;

import kata.web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(long id);
    void update(User user, long id);
    List<User> listUsers();
}
