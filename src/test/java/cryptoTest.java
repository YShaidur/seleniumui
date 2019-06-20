import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ParserToFloat;
import utils.StringReplacer;

import java.util.List;

public class cryptoTest {
    private Driver chromeDriver;
    private WebDriver driver;
    private String link;
    private String actualLink;
    private Actions actions;
    private ParserToFloat parser;
    private StringReplacer replacer;
    private float temp;
    private String partOfLink;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        chromeDriver = Driver.getInstance();
        driver = chromeDriver.getDriver();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        parser = new ParserToFloat();
        replacer = new StringReplacer();
    }

    @Test
    public void cryptoTest(){
        //grab table
        driver.get("https://coinmarketcap.com/");
        WebElement table = driver.findElement(By.id("currencies"));

        //close cookie inform message
        driver.findElement(By.cssSelector("body > div.banner-alert.banner-alert-fixed-bottom.js-cookie-policy-banner > div.banner-alert-close > button > span")).click();

        List<WebElement> allRows = table.findElements(By.cssSelector("tbody > tr"));

        for (WebElement row: allRows) {
            WebElement rowsElem = wait.until(ExpectedConditions.visibilityOf(row.findElement(By.cssSelector("td:nth-child(1)"))));
            actions.moveToElement(rowsElem).perform();

            temp = parser.convertToFloat
                    (replacer.removeSymbols(row.findElement(By.cssSelector("td:nth-child(4)")).getText()));

                if (700 < temp & temp < 720) {

                    partOfLink = row.findElement(By.cssSelector("td:nth-child(2)")).getText().toLowerCase();

                    WebElement graphColumn = row.findElement(By.cssSelector("td:nth-child(8) > a"));
                    graphColumn.click();
                    break;


                } else System.out.println("We search shines: " + temp);

        }

        actualLink = "https://coinmarketcap.com/currencies/"+
                partOfLink+"/#charts";

        link = driver.getCurrentUrl();

        Assert.assertEquals( link, actualLink);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
