package validator;

import api.UserDao;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;

    public UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean isLoginAlreadyExists(String login) {
        UserDao userDao = null;
        try {
            userDao = (UserDao) userDao.getUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (userDao == null) return false;

        return true;
    }

}
