import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class cryptoTest {
    private Driver chromeDriver;
    private WebDriver driver;
    private final String PRICE = "UNUS SED LEO";

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
        WebElement elem = driver.findElement(By.cssSelector("tr > td:nth-child(8)"));

       /* List<WebElement> allRows = table.findElements(By.tagName("tr"));
        System.out.println(allRows.size());*/

        /*for (WebElement row: allRows){
            List<WebElement> pricesCells= row.findElements(By.cssSelector("tr > td:nth-child(4)"));
            List<WebElement> pricesCells= row.findElements(By.cssSelector("tr > td"));

            for (WebElement cell: pricesCells){
                if (cell.findElements(By.cssSelector("td:nth-child(2)")).equals(PRICE)){
                    System.out.println(cell.getText());
                }
                else System.out.println("not found");
                System.out.println(cell.getText());
            }
        }*/

        List<WebElement> col = table.findElements(By.className("currency-name-container link-secondary"));

        Iterator<WebElement> iter = col.iterator();

        while (iter.hasNext()){

            System.out.println(iter.next().getText());

            /*if (iter.next().getText().equals(PRICE)){
                elem.click();
                break;
            }
            else {
                System.out.println("not found");
            }*/

            /*String values = iter.next().getText();

            if (values.equals(PRICE)){
                elem.click();
                System.out.println("not found");
                break;
            }

            else {
                System.out.println("not found");
            }*/
        }



        driver.quit();
        driver = null;
    }
}
