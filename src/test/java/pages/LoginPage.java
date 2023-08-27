package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";
    private static final By EMAIL_FIELD = By.xpath(".//input[@name='name']");
    private static final By PASSWORD_FIELD = By.xpath(".//input[@name='Пароль']");
    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void fillEmail(String email) {
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    private void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void fillLoginForm(String email, String password){
        fillEmail(email);
        fillPassword(password);
    }

    public void waitForLoginButton() {
        Util.waitForElementToBeClickable(driver, LOGIN_BUTTON);
    }

    public void clickLoginButton(){
        Util.clickElement(driver, LOGIN_BUTTON);
    }


    public void openMaximizedAndWait() {
        Util.openMaximized(driver, URL);
        Util.waitForPageLoaded(driver, "login");
    }
}