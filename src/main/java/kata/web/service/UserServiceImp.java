package kata.web.service;

import kata.web.dao.UserDao;
import kata.web.dao.UserDaoImp;
import kata.web.model.User;

import java.util.List;

public class UserServiceImp implements UserService{

    private UserDao userDao = new UserDaoImp();

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user, long id) {
        userDao.update(user, id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
