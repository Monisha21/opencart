import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Constants;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.getLoginPageTitle();
        System.out.println("login page title is: " + title);
        Assert.assertEquals(title, Constants.LoginPageTitle);
    }

    @Test(priority = 2, enabled = true)
    public void loginPageUrlTest() {
        String url = loginPage.getLoginPageURL();
        Assert.assertTrue(url.contains(Constants.LoginPageURL));
    }


}
