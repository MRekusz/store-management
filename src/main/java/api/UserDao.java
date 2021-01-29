package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers() throws IOException;

    void saveUser(User user) throws IOException;
    void saveUsers(List<User> users) throws FileNotFoundException;

    User getUserById(Long userId) throws IOException;
    User getUserByLogin(String login) throws IOException;



}
