package pages.CustomerCreation;
import objectRepo.HomePageObjects;
import objectRepo.SignUpObjects;
import org.openqa.selenium.WebDriver;

public class SignUp extends SignUpObjects {
    WebDriver driver;
    public SignUp(WebDriver driver){
        this.driver = driver;
    }

    public static SignUp SignUpObj(WebDriver driver){
        return new SignUp(driver);
    }

    public void clickCreateBtn() throws InterruptedException {
        driver.findElement(HomePageObjects.SignInBtn).click();
        Thread.sleep(2000);
        driver.findElement(HomePageObjects.CreateAccBtn).click();
    }

    public void enterDetails(String email) throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(SignUpObjects.FName).sendKeys("Name");
        driver.findElement(SignUpObjects.LName).sendKeys("LName");
        driver.findElement(SignUpObjects.Email).sendKeys(email);
        driver.findElement(SignUpObjects.ConfirmEmail).sendKeys(email);
        driver.findElement(SignUpObjects.Pass).sendKeys("password@1");
        driver.findElement(SignUpObjects.Phone).sendKeys("9898988989");
        driver.findElement(SignUpObjects.ETerms).click();
    }

    public void clickSignUp(){
        driver.findElement(SignUpObjects.CreateAccBtn).click();
    }

}
