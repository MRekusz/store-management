package validator;

import entity.User;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {

    private final int MIN_LENGTH_LOGIN = 4;
    private final int MIN_LENGTH_PASSWORD = 6;

    private static UserValidator instance = null;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }


    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException {

        if (isLoginLengthEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short");
        }

        if (isPasswordLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException(user.getPassword());
        }
        return true;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;

    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;

    }

}
