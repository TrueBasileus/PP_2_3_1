package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDAO;
import project.entities.User;

import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    public void removeUser(User user) {
        userDAO.removeUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
