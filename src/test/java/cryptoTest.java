import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class cryptoTest {
    private Driver chromeDriver;
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        chromeDriver = Driver.getInstance();
        driver = chromeDriver.getDriver();
    }


    @Test
    public void cryptoTest(){
        //grab table
        driver.get("https://coinmarketcap.com/");
        WebElement table = driver.findElement(By.id("currencies"));

        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        System.out.println(allRows.size());

        for (WebElement row: allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell: cells){
                System.out.println(cell.getText());
            }
        }

        driver.quit();
        driver = null;
    }
}
