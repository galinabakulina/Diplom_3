package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private static final By ENTER_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By PERSONAL_ACCOUNT = By.xpath(".//p[text()='Личный Кабинет']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMaximizedAndWait() {
        Util.openMaximized(driver, URL);
        Util.waitForPageLoaded(driver, "https://stellarburgers.nomoreparties.site");
    }

    public void clickEnterAccountButton() {
        Util.clickElement(driver, ENTER_ACCOUNT_BUTTON);
    }

    public void clickPersonalAccount() {
        Util.clickElement(driver, PERSONAL_ACCOUNT);
    }
}
