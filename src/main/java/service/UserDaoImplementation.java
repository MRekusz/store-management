package service;

import api.UserDao;
import entity.User;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements UserDao {

    private final String fileName;

    public UserDaoImplementation(String fileName) throws IOException {
        this.fileName = fileName;
        FileUtils.touch(new File("UsersFile.txt"));
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public List<User> getAllUsers() throws IOException {

        List<User> users = new ArrayList<>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readOneLine = bufferedReader.readLine();
        while (readOneLine != null) {
            readOneLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users
        ) {
            boolean isFoundUser = user.getLogin().equals(login);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            boolean isUserById = user.getId() == userId;
            if (isUserById) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).getId() == userId;
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).equals(login);
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }
}


