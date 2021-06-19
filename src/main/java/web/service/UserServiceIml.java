package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDaoImpl;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceIml implements UserService, UserDetailsService {

    @Autowired
    UserDao userDAO;

    @Autowired
    RoleDaoImpl roleDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserServiceIml() {
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        Set<Role> roles = new HashSet<>();
        System.out.println(user.getUsername());
        System.out.println(user.getName());
        if (user.getId() == 1) {
            roles.add(roleDAO.getRoleById(1));
        } else {
            roles.add(roleDAO.getRoleById(2));
        }
        user.setRoles(roles);
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRoleById(2));
        user.setRoles(roles);
        userDAO.addUser(user);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }


    public User findByUsername(String username) {
        return userDAO.getUserByName(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}