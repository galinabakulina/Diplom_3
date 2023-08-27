import data.*;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class ValidRegistrationTest extends TestBase {
    private final String name = "Galina";
    private String email;
    private final String password = "q1w2e3r4t5ty6";
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        email = UUID.randomUUID() + "_galina@yandex.ru";
        registrationPage = new RegistrationPage(driver);
        registrationPage.openMaximizedAndWait();
    }

    @Test
    public void checkValidRegistration(){
        registrationPage.fillAuthForm(name, email, password);
        registrationPage.clickAuthButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginButton();
        String actualUrl = driver.getCurrentUrl();
        assertThat(actualUrl, containsString("login"));
    }

    @After
    public void tearDown() {
        deleteUser(email, password);
    }
}
