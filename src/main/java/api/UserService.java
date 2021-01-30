package api;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws IOException;
    boolean addUser(User user) throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException;
    void removeUserById(long id) throws IOException;
    public boolean isCorrectLoginAndPassword(String login, String password);


}
