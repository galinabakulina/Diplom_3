import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ShortPasswordTest extends TestBase {
    private final String name = "Galina";
    private String email;
    private final String password = "short";
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        email = UUID.randomUUID() + "_galina@yandex.ru";
        registrationPage = new RegistrationPage(driver);
        registrationPage.openMaximizedAndWait();
    }

    @Test
    public void getIncorrectPasswordError() {
        registrationPage.fillAuthForm(name, email, password);
        registrationPage.clickAuthButton();
        registrationPage.waitForShortPasswordError();
        String actual = registrationPage.getShortPasswordErrorText();
        String expected = "Некорректный пароль";
        assertEquals(expected, actual);
    }
}
