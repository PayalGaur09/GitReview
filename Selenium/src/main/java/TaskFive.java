import com.sun.org.apache.bcel.internal.generic.NEW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TaskFive {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.in/");

        WebElement deals = driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]"));
        deals.click();

        WebElement viewDeal = driver.findElement(By.xpath("(//a[contains(text(),'View Deal')])[1]"));
        viewDeal.click();

        //driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        driver.findElement(By.xpath("//a[@class='a-link-normal s-access-detail-page s-color-twister-title-link a-text-normal']")).click();
        Set<String> sessions=driver.getWindowHandles();
        Iterator<String> itr=sessions.iterator();
// Thread.sleep(10000);
        String parentID=itr.next();
        System.out.println(parentID);
        String childID=itr.next();
        System.out.println(childID);
        driver.switchTo().window(childID);
        WebDriverWait wait=new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("native_dropdown_selected_size_name")));
        WebElement elmnt=driver.findElement(By.id("native_dropdown_selected_size_name"));
        Select sel= new Select(elmnt);
        sel.selectByIndex(1);


       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));
       WebElement addToCartBtn = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
       addToCartBtn.click();




    }
}