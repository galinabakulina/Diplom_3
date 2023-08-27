package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private static final By ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMaximizedAndWait() {
        Util.openMaximized(driver, URL);
        Util.waitForPageLoaded(driver, "https://stellarburgers.nomoreparties.site");
    }

    public void clickAccountButton() {
        Util.clickElement(driver, ACCOUNT_BUTTON);
    }
}
