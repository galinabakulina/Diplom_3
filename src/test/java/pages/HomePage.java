package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private static final By ENTER_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By PERSONAL_ACCOUNT = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By BUNS = By.xpath( ".//span[text() = 'Булки']");
    private static final By SAUCES = By.xpath( ".//span[text() = 'Соусы']");
    private static final By FILLINGS = By.xpath( ".//span[text() = 'Начинки']");
    private final By CURRENT = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span");
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

    public String chooseBuns() {
        Util.waitForElementToBeClickable(driver, BUNS);
        Util.clickElement(driver, BUNS);
        System.out.println(driver.findElement(CURRENT).getText());
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElementLocated(CURRENT, "Булки"));
        System.out.println(driver.findElement(CURRENT).getText());
        return driver.findElement(CURRENT).getText();
    }
    public String chooseSauces() {
        Util.waitForElementToBeClickable(driver, SAUCES);
        Util.clickElement(driver, SAUCES);
        System.out.println(driver.findElement(CURRENT).getText());
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElementLocated(CURRENT, "Соусы"));
        System.out.println(driver.findElement(CURRENT).getText());
        return driver.findElement(CURRENT).getText();
    }
    public String chooseFillings() {
        Util.waitForElementToBeClickable(driver, FILLINGS);
        Util.clickElement(driver, FILLINGS);
        System.out.println(driver.findElement(CURRENT).getText());
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElementLocated(CURRENT, "Начинки"));
        System.out.println(driver.findElement(CURRENT).getText());
        return driver.findElement(CURRENT).getText();
    }
}
