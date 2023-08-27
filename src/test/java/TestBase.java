import data.LoginResponse;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

public class TestBase {
    protected WebDriver driver;

    private String tempUserEmail;
    private final String tempUserPassword = "q1w2e3r4t5ty6";
    private final String tempUserName = "Galina";

    @Before
    public void createTemporaryUser() {
        tempUserEmail = UUID.randomUUID() + "_galina@yandex.ru";
        RestAssured.baseURI = ApiHelper.URL;
        ApiHelper.registerUser(tempUserEmail, tempUserPassword, tempUserName);
    }

    @Before
    public void setUpDriver() {
        // Uncomment the following line to disable Chrome and use Yandex
        // System.setProperty("webdriver.chrome.driver", "/Users/galinalobanova/WebDriver/bin/yandexdriver");
        driver = new ChromeDriver();
    }

    @After
    public void deleteTemporaryUser() {
        deleteUser(tempUserEmail, tempUserPassword);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    protected String getTempUserEmail() {
        return tempUserEmail;
    }

    protected String getTempUserPassword() {
        return tempUserPassword;
    }

    protected String getTempUserName() {
        return tempUserName;
    }

    protected void deleteUser(String email, String password) {
        RestAssured.baseURI = ApiHelper.URL;
        LoginResponse loginResponse = ApiHelper.login(email, password)
                .body()
                .as(LoginResponse.class);
        String accessToken = loginResponse.getAccessToken();
        ApiHelper.deleteUser(accessToken);
    }
}
