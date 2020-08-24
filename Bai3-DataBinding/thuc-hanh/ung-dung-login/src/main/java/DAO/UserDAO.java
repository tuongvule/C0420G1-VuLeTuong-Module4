package DAO;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User user1 = new User("john1","123456","John1","john1@gmai.com",25);
        User user2 = new User("john2","123789","John2","john2@gmai.com",26);
        User user3 = new User("john3","456789","John3","john3@gmai.com",27);
        User user4 = new User("john4","654321","John4","john4@gmai.com",28);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }
    public static User checkLogin(Login login){
        for(User u:users) {
            if (login.getAccount().equals(u.getAccount()) & login.getPassword().equals(u.getPassword())) {
                return u;
            }
        }
            return null;

    }
}
