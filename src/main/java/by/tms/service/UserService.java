package by.tms.service;

import by.tms.dao.InMemoryUserStorage;
import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final InMemoryUserStorage userStorage;

    public UserService(InMemoryUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public boolean save(String name, String username, String password) {
        User user= new User(name,username,password);
        if(userStorage.findByUsername(user.getUsername())==null){
            userStorage.save(user);
            return true;
        }else {
            return false;
        }
    }

    public boolean save(User user) {
        if(userStorage.findByUsername(user.getUsername())==null){
            userStorage.save(user);
            return true;
        }else {
            return false;
        }
    }

    public User findByUsername(String username){
        return userStorage.findByUsername(username);
    }

    private List<User> findAll(){
        return userStorage.findAll();
    }

    public void deleteUser(User user){
        userStorage.deleteUser(user);
    }
}
