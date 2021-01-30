package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImplementation;

import java.io.IOException;

public class UserRegisterLoginFacadeImplementation implements UserRegisterLoginFacade {

    private static UserRegisterLoginFacade instance = null;
    private UserService userService = UserServiceImplementation.getInstance();

    private UserRegisterLoginFacadeImplementation() {
    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImplementation();
        }
        return instance;
    }

    @Override
    public boolean registerUser(User user) {
        try {
            return userService.addUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }
}
