package by.tms.dao;


import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class InMemoryUserDao implements UserDao{

    private List<User> userList;

    public InMemoryUserDao(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public User findByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void deleteUser(User user) {
        userList.remove(user);
    }
}
