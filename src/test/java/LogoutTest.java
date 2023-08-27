import org.junit.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class LogoutTest extends TestBase{
    @Test
    public void logOut(){
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

        profilePage.clickLogoutButton();

        loginPage = new LoginPage(driver);
        loginPage.waitForLoginButton();
        String actualUrl = driver.getCurrentUrl();
        assertThat(actualUrl, containsString("login"));
    }

}
