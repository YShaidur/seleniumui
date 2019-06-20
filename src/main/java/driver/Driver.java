package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static Driver instance = null;
    private WebDriver driver;

    private Driver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quitDriver(){
        if (null != driver){
            driver.quit();
            driver = null;
        }
    }

    public static Driver getInstance(){
        if (instance == null){
            instance = new Driver();
        }

        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
