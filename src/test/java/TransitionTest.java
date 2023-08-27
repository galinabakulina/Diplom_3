import org.junit.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import static org.junit.Assert.assertEquals;

public class TransitionTest extends TestBase {

    @Test
    public void openProfile(){
        HomePage homePage = new HomePage(driver);
        homePage.openMaximizedAndWait();
        homePage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginButton();
        loginPage.fillLoginForm(getTempUserEmail(), getTempUserPassword());
        loginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForOrderButton();
        accountPage.openProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();

        String expected = "Профиль";
        String actual = profilePage.getProfileText();
        assertEquals(expected, actual);
    }

    @Test
    public void openConstructorViaLink(){
        HomePage homePage = new HomePage(driver);
        homePage.openMaximizedAndWait();
        homePage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginButton();
        loginPage.fillLoginForm(getTempUserEmail(), getTempUserPassword());
        loginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForOrderButton();
        accountPage.openProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();

        profilePage.clickConstructorLink();

        accountPage = new AccountPage(driver);
        accountPage.waitForOrderButton();

        String expected = "Оформить заказ";
        String actual = accountPage.getOrderButtonText();
        assertEquals(expected, actual);
    }

    @Test
    public void openConstructorViaLogo(){
        HomePage homePage = new HomePage(driver);
        homePage.openMaximizedAndWait();
        homePage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginButton();
        loginPage.fillLoginForm(getTempUserEmail(), getTempUserPassword());
        loginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForOrderButton();
        accountPage.openProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();

        profilePage.clickConstructorLogo();

        accountPage = new AccountPage(driver);
        accountPage.waitForOrderButton();

        String expected = "Оформить заказ";
        String actual = accountPage.getOrderButtonText();
        assertEquals(expected, actual);
    }

}
