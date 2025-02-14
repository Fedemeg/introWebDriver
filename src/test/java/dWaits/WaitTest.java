package test.java.dWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by design on 11/17/17.
 */
public class WaitTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("http://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.id("searchInput"));

        searchInput.clear();
        searchInput.sendKeys("Mobile Telephone System");
        
        driver.findElement(By.cssSelector("button.pure-button")).click();
        
        driver.close();
    }

}
