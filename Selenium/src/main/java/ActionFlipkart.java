import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionFlipkart {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.navigate().to("https://www.flipkart.com/");
        WebElement cross = driver.findElement(By.xpath("//button[text()='X']"));
        cross.click();
        Actions act = new Actions(driver);
        WebElement electronics= driver.findElement(By.xpath("//span[text()='Electronics']"));
        act.moveToElement(electronics).perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Mi")).click();
        Thread.sleep(1000);

        WebElement slider = driver.findElement(By.cssSelector("div[class='_3G9WVX oVjMho']"));
        act.dragAndDropBy(slider, 68, 0);
    }
}