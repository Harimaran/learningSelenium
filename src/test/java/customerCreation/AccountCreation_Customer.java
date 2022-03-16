package customerCreation;

import database.Database;
import driverFactory.InstanceClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CustomerCreation.SignUp;
import utility.BasicUtils;
import java.io.IOException;
import java.sql.SQLException;

public class AccountCreation_Customer {
    WebDriver driver =null;
    String Email = null;

    @BeforeTest
    public void gotoSite(){
        driver = InstanceClass.initializeDriver();
        InstanceClass.enterToSite("https://qa-ecom-aws.avon.com/");
    }

    @Test (priority = 1)
    @Parameters ("email")
    public void enterValidDetailsAndSignUp(String email) throws InterruptedException, IOException {
        SignUp signup = SignUp.SignUpObj(driver);
        signup.clickCreateBtn();
        signup.enterDetails(email);
        signup.clickSignUp();
        BasicUtils.enterOtp(driver);
        BasicUtils.takeSnip(driver);
    }

    @Test (priority = 2 , enabled = false)
    public void enterInvalidDetailsAndSignUp() throws InterruptedException, IOException {
        SignUp signup = SignUp.SignUpObj(driver);
        signup.clickCreateBtn();
        signup.enterDetails("newavon40@rep.com");
        signup.clickSignUp();
        BasicUtils.enterOtp(driver);
        BasicUtils.takeSnip(driver);
    }

    @Test (priority = 2)
    @Parameters ("email")
    public void CheckAcctTypeInDB(String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Database con2DB = Database.databaseAccess();
        con2DB.connectToDB();
        con2DB.executeQuery(email);
        String result = con2DB.getResultFromQuery("AcctType");
        Assert.assertEquals(result, "UE");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException, IOException {
        driver.quit();
    }
}
