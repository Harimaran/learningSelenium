package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class InstanceClass {
    static WebDriver driver = null;
    String url = null;

    public static WebDriver initializeDriver(){
            ChromeOptions  opt = new ChromeOptions();
            opt.setHeadless(true);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(opt);
            driver.manage().window().maximize();
            return driver;
    }

    public static void enterToSite(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
