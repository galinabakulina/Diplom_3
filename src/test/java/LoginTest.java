import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {

    @Test
    public void loginTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openMaximizedAndWait();
        homePage.clickAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginButton();
        loginPage.fillLoginForm(getTempUserEmail(), getTempUserPassword());
        loginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForOrderButton();

        String expected = "Оформить заказ";
        String actual = accountPage.getOrderButtonText();
        assertEquals(expected, actual);
    }
}
