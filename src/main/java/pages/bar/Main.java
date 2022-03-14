package pages.bar;

import database.Database;
import driverFactory.InstanceClass;
import org.openqa.selenium.WebDriver;
import pages.CustomerCreation.SignUp;
import utility.BasicUtils;


import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        WebDriver driver = null;
//        String email = "newcust12@rep.com";
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://qa-ecom-aws.avon.com/");
        driver = InstanceClass.initializeDriver();
        InstanceClass.enterToSite("https://qa-ecom-aws.avon.com/");
        BasicUtils.takeSnip(driver);

//        SignUp obj = new SignUp(driver);
//        obj.clickCreateBtn();
//        String email = "newavon@rep.com";
//        obj.enterDetails(email);
//        BasicUtils.takeSnip(driver);
//        obj.clickSignUp();
//        BasicUtils.enterOtp(driver);




    }
}
