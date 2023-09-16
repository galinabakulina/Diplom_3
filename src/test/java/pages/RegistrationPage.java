package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By NAME_FIELD = By.xpath(".//input[@name='name']");
    private static final By EMAIL_FIELD = By.xpath(".//input[@name='name']");
    private static final By PASSWORD_FIELD = By.xpath(".//input[@name='Пароль']");
    private static final By AUTH_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By LOGIN = By.xpath(".//a[text()='Войти']");
    private static final By SHORT_PSW_ERROR =By.xpath(".//p[@class='input__error text_type_main-default']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMaximizedAndWait() {
        Util.openMaximized(driver, URL);
        Util.waitForPageLoaded(driver, "register");
    }

    public void waitForShortPasswordError() {
        Util.waitForPresenceOfElementLocated(driver, SHORT_PSW_ERROR);
    }

    public String getShortPasswordErrorText() {
        return driver.findElement(SHORT_PSW_ERROR).getText();
    }

    private void fillName(String name) {
        Util.waitForPresenceOfElementLocated(driver, NAME_FIELD);
        driver.findElements(NAME_FIELD).get(0).clear();
        driver.findElements(NAME_FIELD).get(0).sendKeys(name);
    }

    private void fillEmail(String email) {
        driver.findElements(EMAIL_FIELD).get(1).clear();
        driver.findElements(EMAIL_FIELD).get(1).sendKeys(email);
    }

    private void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void fillAuthForm(String name, String email, String password){
        fillName(name);
        fillEmail(email);
        fillPassword(password);
    }

    public void clickAuthButton(){
        Util.clickElement(driver, AUTH_BUTTON);
    }

    public void clickLoginButton(){
        Util.clickElement(driver, LOGIN);
    }
}
