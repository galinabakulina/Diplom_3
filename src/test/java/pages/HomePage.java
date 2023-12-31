package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public String chooseMenuSection(String section) {
        By locator = BUNS;
        switch(section) {
            case "Соусы":
                locator = SAUCES;
                Util.waitForElementToBeClickable(driver, locator);
                Util.clickElement(driver, locator);
                System.out.println(driver.findElement(CURRENT).getText());
                break;
            case "Начинки":
                locator = FILLINGS;
                Util.waitForElementToBeClickable(driver, locator);
                Util.clickElement(driver, locator);
                System.out.println(driver.findElement(CURRENT).getText());
                break;
            default:
                System.out.println(driver.findElement(CURRENT).getText());
        }


        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElementLocated(CURRENT, section));
        System.out.println(driver.findElement(CURRENT).getText());
        return driver.findElement(CURRENT).getText();
    }
    
}
