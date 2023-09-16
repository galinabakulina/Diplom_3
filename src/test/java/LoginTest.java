import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {

    @Test
    public void testLoginViaEnterAccountButton(){
        HomePage homePage = new HomePage(driver);
        homePage.openMaximizedAndWait();
        homePage.clickEnterAccountButton();

        logIn();
    }

    @Test
    public void testLoginViaPersonalAccount(){
        HomePage homePage = new HomePage(driver);
        homePage.openMaximizedAndWait();
        homePage.clickPersonalAccount();

        logIn();
    }

    @Test
    public void testLoginViaRegistrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openMaximizedAndWait();
        registrationPage.clickLoginButton();

        logIn();
    }

    @Test
    public void testLoginViaForgotPasswordPage(){
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.openMaximizedAndWait();
        forgotPasswordPage.clickLoginButton();

        logIn();
    }

    private void logIn() {
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
