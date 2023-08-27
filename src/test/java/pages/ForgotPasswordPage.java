package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private static final By LOGIN = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMaximizedAndWait() {
        Util.openMaximized(driver, URL);
        Util.waitForPageLoaded(driver, "forgot-password");
    }

    public void clickLoginButton(){
        Util.clickElement(driver, LOGIN);
    }

}
