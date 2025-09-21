package Service;

import DAO.UserDAOImpl;
import model.User;


public class UserService {

    private UserDAOImpl userDAOimpl = new UserDAOImpl();
    public UserService() {}

    public User readUser(int id) {
        return userDAOimpl.read(id);
    }

    public User createUser(String name, String email, int age) {
        User user = new User(name, email, age);
        return userDAOimpl.create(user);
    }

    public User updateUser(int id, String name, String email) {
        User user = userDAOimpl.read(id);
        if (user == null) {
            throw new IllegalArgumentException("Not found" + id);
        }
        if (name != null) user.setName(name);
        if (email != null) user.setEmail(email);
        return userDAOimpl.update(user);
    }

    public void deleteUser(User user) {
        userDAOimpl.delete(user);
    }

    public void deleteUserById(int id) {
        userDAOimpl.delete(id);
    }

}
