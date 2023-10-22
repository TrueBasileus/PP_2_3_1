package project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entities.User;

import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager em;


    public List<User> getAllUsers() {
        return em.createQuery("select u from User u").getResultList();

    }

    public User getUserById(int id) {
        return em.find(User.class, id);

    }

    public void removeUser(User user) {
        System.out.println(user);
        em.remove(em.find(User.class, user.getId()));

    }

    public void updateUser(User user) {
        User updatedUser = em.find(User.class, user.getId());
        updatedUser.setAge(user.getAge());
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
    }

    public void addUser(User user) {
        em.persist(user);
    }
}
