import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import utils.BaseTest;
import utils.Constants;

public class MyAccountPageTest extends BaseTest {

    @BeforeClass
    public void accPageSetUp(){
        myAccountPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
    }

    @Test
    public void validateAccPageTitle(){
            String title = myAccountPage.getAccountPageTitle();
        Assert.assertEquals(title, Constants.MyAccountPageTitle);
    }

    @Test
    public void validateAccPageURL(){
        String accountPageUrl = myAccountPage.getAccountPageUrl();
        Assert.assertTrue(accountPageUrl.contains(Constants.MyAccountPageURL));
    }
}
