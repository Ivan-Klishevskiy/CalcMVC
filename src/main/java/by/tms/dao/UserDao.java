package by.tms.dao;

import by.tms.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

    void deleteUser(User user);
}
