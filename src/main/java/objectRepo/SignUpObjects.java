package objectRepo;

import org.openqa.selenium.By;

public class SignUpObjects extends HomePageObjects{
    protected static final By FName = By.name("firstName");
    protected static final By LName = By.name("lastName");
    protected static final By Email = By.id("emailAddr");
    protected static final By ConfirmEmail = By.id("confirmEmailAddr");
    protected static final By Pass = By.id("password");
    protected static final By Phone = By.id("phoneNumber");
    protected static final By ETerms = By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div[1]/div[6]/div[2]/label/label/span[1]/span/input");
    protected static final By CreateAccBtn = By.xpath("//button[text()='Create Account']");


}
