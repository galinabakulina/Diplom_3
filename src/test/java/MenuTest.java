import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MenuTest extends TestBase {
   private String section;

   public MenuTest(String section) {
      this.section = section;
   }

   @Parameterized.Parameters
   public static Object[][] getTestData() {
      return new Object[][] {
              {"Булки"},
              {"Соусы"},
              {"Начинки"}
      };
   }

   @Test
    public void checkMenuSection(){
       HomePage homePage = new HomePage(driver);
       homePage.openMaximizedAndWait();
       String expected = section;
       String actual = homePage.chooseMenuSection(section);
       assertEquals(expected, actual);

   }
}
