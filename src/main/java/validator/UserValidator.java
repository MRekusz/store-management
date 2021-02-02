package validator;

import api.UserDao;
import api.UserService;
import dao.UserDaoImplementation;
import entity.User;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_LOGIN = 4;
    private final int MIN_LENGTH_PASSWORD = 6;

    private static UserValidator instance = null;
    private UserDao userDao = UserDaoImplementation.getInstance();

    private UserValidator() {
    }


    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }


    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException, LoginException {

        if (isLoginLengthEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short");
        }

        if (isPasswordLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short");
        }

        if (isLoginAlreadyExist(user.getLogin())) {
            throw new LoginException("Login already exists");
        }
        return true;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;

    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;

    }

    private boolean isLoginAlreadyExist(String login) {
        UserService user = null;
        try {
            user = (UserService) user.getUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (user == null) return false;
        return true;
    }
}
