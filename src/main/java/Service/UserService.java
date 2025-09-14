package Service;

import DAO.UserDAOImpl;
import model.User;

import java.util.Optional;

public class UserService {

    private UserDAOImpl userDAOimpl = new UserDAOImpl();
    public UserService() {}

    public Optional<User> readUser(int id) {
        return userDAOimpl.read(id);
    }

    public User createUser(User user) {
        return userDAOimpl.create(user);
    }

    public User updateUser(User user) {
        return userDAOimpl.update(user);
    }

    public void deleteUser(User user) {
        userDAOimpl.delete(user);
    }

}
