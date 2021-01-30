package service;

import api.UserDao;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImplementation implements UserService {

    private static UserServiceImplementation instance = null;
    private UserDao userDao = (UserDao) UserServiceImplementation.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImplementation() {
    }

    public static UserServiceImplementation getInstance() {
        if (instance == null) {
            instance = new UserServiceImplementation();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public User getUserByLogin(String login) {
        List<User> users = null;
        try {
            userDao.getAllUsers();
            for (User user : users) {
                boolean isFoundUser = user.getLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);

        return user != null;
    }

    @Override
    public boolean addUser(User user) {
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void removeUserById(long id) throws IOException {
            userDao.removeUserById(id);
    }
}

