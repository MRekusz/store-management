package service;

import api.UserDao;
import entity.User;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserDaoImplementation implements UserDao {

    private final String fileName;

    public UserDaoImplementation(String fileName) throws IOException {
        this.fileName = fileName;
        FileUtils.touch(new File("UsersFile.txt"));
    }

    @Override
    public void saveUser(User user) {


    }

    @Override
    public void saveUsers(List<User> users) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public void removeUserByLogin(String login) {

    }

    @Override
    public void removeUserById(Long id) {

    }
}
