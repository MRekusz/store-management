package entity;

public class User {


    long id;
    String login;
    String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
