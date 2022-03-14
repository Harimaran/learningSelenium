package customerCreation;

import database.Database;
import driverFactory.InstanceClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CustomerCreation.SignUp;
import utility.BasicUtils;
import java.io.IOException;
import java.sql.SQLException;

public class AccountCreation_Customer {
    WebDriver driver =null;

    @Test (priority = 0)
    public void gotoSite(){
        driver = InstanceClass.initializeDriver();
        InstanceClass.enterToSite("https://qa-ecom-aws.avon.com/");
    }

    @Test (priority = 1)
    public void enterValidDetailsAndSignUp() throws InterruptedException, IOException {
        SignUp signup = SignUp.SignUpObj(driver);
        signup.clickCreateBtn();
        signup.enterDetails("newavon57@rep.com");
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
    public void CheckAcctTypeInDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Database con2DB = Database.databaseAccess();
        con2DB.connectToDB();
        con2DB.executeQuery("newavon51@rep.com");
        String result = con2DB.getResultFromQuery("AcctType");
        System.out.println(result);
        Assert.assertEquals(result, "UE");
    }

    @Test(enabled = false)
    public void closeBrowser() throws InterruptedException, IOException {
        driver.quit();
    }
}
