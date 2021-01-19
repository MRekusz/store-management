package service;

import api.UserDao;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImplementation implements UserService {

    private static UserServiceImplementation instance = null;
    private UserDao userDao = (UserDao) UserServiceImplementation.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImplementation() {
    }

    public static UserServiceImplementation getInstance(){
        if (instance == null){
            instance = new UserServiceImplementation();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }


    @Override
    public void addUser(User user)throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException {
        if (userValidator.isValidate(user)){
            userDao.saveUser(user);
        }
    }

    @Override
    public void removeUserById(long id) throws IOException {
        userDao.removeUserById(id);
        }
    }

