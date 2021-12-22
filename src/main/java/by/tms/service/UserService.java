package by.tms.service;

import by.tms.dao.HibernateUserDao;
import by.tms.dao.InMemoryUserDao;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserService {

    @Autowired
    private HibernateUserDao hibernateUserDao;


    public boolean save(String name, String username, String password) {
        User user= new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        if(hibernateUserDao.findByUsername(user.getUsername()) ==null){
            hibernateUserDao.save(user);
            return true;
        }else {
            return false;
        }
    }

    public User findByUsername(String username){
        return hibernateUserDao.findByUsername(username);
    }

    private List<User> findAll(){
        return hibernateUserDao.findAll();
    }

    public void deleteUser(User user){
        hibernateUserDao.deleteUser(user);
    }
}
