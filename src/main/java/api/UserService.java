package api;

import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws IOException;

    boolean addUser(User user);

    void removeUserById(long id) throws IOException;
    User getUserByLogin(String login) throws IOException;

    public boolean isCorrectLoginAndPassword(String login, String password);


}
