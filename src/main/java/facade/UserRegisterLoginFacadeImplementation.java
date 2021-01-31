package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImplementation;

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
            return userService.addUser(user);

    }

    @Override
    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }
}
