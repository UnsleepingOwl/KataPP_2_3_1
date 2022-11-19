package kata.web.dao;

import kata.web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao {

    ////
    private static long ID = 1;
    private List<User> debugUserList = new ArrayList<>();
    {
        debugUserList.add(new User(++ID, "name"+ID, "lastName"+ID,(byte) ID));
        debugUserList.add(new User(++ID, "name"+ID, "lastName"+ID,(byte) ID));
        debugUserList.add(new User(++ID, "name"+ID, "lastName"+ID,(byte) ID));
        debugUserList.add(new User(++ID, "name"+ID, "lastName"+ID,(byte) ID));
        debugUserList.add(new User(++ID, "name"+ID, "lastName"+ID,(byte) ID));
    }

    @Override
    public void add(User user) {
        debugUserList.add(user);
    }

    @Override
    public void delete(long id) {
        User deletedUser = getUserById(id);
        debugUserList.removeIf(user -> user.getId() == id);
    }

    @Override
    public void update(User user, long id) {
        User updatedUser = getUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
    }

    @Override
    public List<User> listUsers() {
        return debugUserList;
    }

    @Override
    public User getUserById(long id) {
        return debugUserList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
