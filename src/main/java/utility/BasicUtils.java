package utility;

import objectRepo.CommonObjects;
import objectRepo.SignUpObjects;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasicUtils extends CommonObjects {
    private static final String otp = "111111";

    public static void waitForSomeTime(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForSomeTime(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void takeSnip(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./pic1.png"));
    }

    public static void enterOtp(WebDriver driver) throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(CommonObjects.OtpBox).sendKeys(otp);
        driver.findElement(CommonObjects.ContBtn).click();
    }


}
