package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private static final By ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForOrderButton() {
        Util.waitForElementToBeClickable(driver, ORDER_BUTTON);
    }

    public String getOrderButtonText() {
        return driver.findElement(ORDER_BUTTON).getText();
    }
}
