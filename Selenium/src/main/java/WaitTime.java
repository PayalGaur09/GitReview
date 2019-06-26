import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitTime {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.flipkart.com/");
        //driver.findElement(By.xpath("//button[text()='X'")).click();
        WebDriverWait wait= new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='X'"))).click();


    }
}