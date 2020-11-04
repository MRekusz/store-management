package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImplementation implements UserService {

    List<User> users;

    public UserServiceImplementation() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImplementation(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUserById(long id) {
        for (int i = 0; i < users.size(); i++) {
            User userFromList = users.get(i);
            if (userFromList.getId() == id) {
                users.remove(i);
                break;
            }
        }
    }
}
