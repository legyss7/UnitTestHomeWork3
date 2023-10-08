package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных
    // пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       //..
        if(user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String userName) {
        for (User user : data) {
            if (user.name.equals(userName)) {
                return true;
            }
        }
        return false;
    }

}