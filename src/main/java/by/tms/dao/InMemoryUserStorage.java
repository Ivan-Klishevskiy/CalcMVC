package by.tms.dao;


import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class InMemoryUserStorage {

    private List<User> userList;

    public InMemoryUserStorage(List<User> userList) {
        this.userList = userList;
    }

    public void save(User user) {
        userList.add(user);
    }

    public User findByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return userList;
    }

    public void deleteUser(User user) {
        userList.remove(user);
    }
}
