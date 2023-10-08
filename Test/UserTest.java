import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private UserRepository userRepository;
    private String userName = "us0";
    private String userPassword = "123";
    boolean boolAdmin = false;

    @BeforeEach
    void setUp() {
        user = new User(userName, userPassword, boolAdmin);
        userRepository = new UserRepository();
    }

    /**
     * 3.6. Разработайте класс User с методом аутентификации по
     * логину и паролю. Метод должен возвращать true, если
     * введенные логин и пароль корректны, иначе false.
     * Протестируйте все методы
     */
    @Test
    void theEnteredDataIsCorrect() {
        assertTrue(user.authenticate(userName, userPassword));
    }

    @Test
    void incorrectDataEntered() {
        assertFalse(user.authenticate(userName + "1", userPassword));
    }

    /**
     * 3.7 Добавьте класс UserRepository для управления пользователями.
     * В этот класс должен быть включен метод addUser, который добавляет
     * пользователя в систему, если он прошел аутентификацию. Покройте
     * тестами новую функциональность
     */
    //пользователь добавлен
    @Test
    void userAdded() {
        user.authenticate(userName, userPassword);
        userRepository.addUser(user);
        assertTrue(userRepository.findByName(userName));
    }
    //пользователь не добавлен
    @Test
    void userNotAdded () {
        user.authenticate(userName + "a", userPassword);
        userRepository.addUser(user);
        assertFalse(userRepository.findByName(userName));
    }
    //пользователь с таким именем не найден
    //for (User user : data) {}
    @Test
    void userNotFound () {
        user.authenticate(userName, userPassword);
        userRepository.addUser(user);
        assertFalse(userRepository.findByName(userName + "1"));
    }
}
