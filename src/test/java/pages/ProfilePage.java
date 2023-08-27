package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private static final By PROFILE = By.xpath(".//a[text()='Профиль']");
    private static final By LOGO = By.xpath(".//p[text()='Конструктор']");
    private static final By LINK = By.className("AppHeader_header__logo__2D0X2");
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageLoaded(){
        Util.waitForPageLoaded(driver, "/account/profile");
    }

    public String getProfileText() {
        return driver.findElement(PROFILE).getText();
    }

    public void clickConstructorLogo() {Util.clickElement(driver, LOGO);}

    public void clickConstructorLink() {Util.clickElement(driver, LINK);}

}
