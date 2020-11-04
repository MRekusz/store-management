import entity.User;
import org.junit.Assert;
import org.junit.Test;
import service.UserServiceImplementation;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {


    @Test
    public void testGetAllUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "user1", "pass1"));
        users.add(new User(2L, "user3", "pass2"));
        users.add(new User(3L, "user3", "pass3"));
        users.add(new User(4L, "user4", "pass4"));

        UserServiceImplementation userServiceImplementation = new UserServiceImplementation(users);
        List<User> usersFromTestClass = userServiceImplementation.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<>();
        User user = new User(1L, "admin", "admin");
        users.add(user);

        UserServiceImplementation userServiceImplementation = new UserServiceImplementation();
        userServiceImplementation.addUser(user);
        List<User> usersFromTestClass = userServiceImplementation.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUser() {
        List<User> users = new ArrayList<>();
        User user = new User(1L, "user1", "pass1");
        User user1 = new User(2L, "user2", "pass2");
        users.add(user);
        users.add(user1);

        UserServiceImplementation userServiceImplementation = new UserServiceImplementation(users);
        userServiceImplementation.removeUserById(1L);
        users.remove(user);
        List<User> usersFromTestClass = userServiceImplementation.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

}
