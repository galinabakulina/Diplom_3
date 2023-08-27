import org.junit.Test;
import org.openqa.selenium.By;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class MenuTest extends TestBase {
   @Test
    public void checkAllMenuSections(){
       HomePage homePage = new HomePage(driver);
       homePage.openMaximizedAndWait();

       String expected ="Соусы";
       String actual = homePage.chooseSauces();
       assertEquals(expected, actual);

       expected ="Начинки";
       actual = homePage.chooseFillings();
       assertEquals(expected, actual);

       expected ="Булки";
       actual = homePage.chooseBuns();
       assertEquals(expected, actual);

   }
}
