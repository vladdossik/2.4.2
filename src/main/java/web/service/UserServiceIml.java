package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceIml implements UserService, UserDetailsService {
   @Autowired
   UserDao userDao;
   public UserServiceIml(){

   }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public void updateUser(long id, User user) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUser(String name) {
        return null;
    }
}
