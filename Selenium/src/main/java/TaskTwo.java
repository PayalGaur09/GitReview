import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class TaskTwo {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.navigate().to("https://www.myntra.com/");
        //driver.navigate.back();
        // driver.navigate.forward();
        String title = driver.getTitle();
        System.out.println("Title :" + title);
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println("Current URL :" + CurrentUrl);
        String PageSource = driver.getPageSource();
        System.out.println("PageSource" + PageSource);

        driver.findElement(By.xpath("//a[@class='desktop-main'][text()='Kids']")).click();
        Set<String> sessions = driver.getWindowHandles();
        Iterator<String> itr = sessions.iterator();
        String parentID = itr.next();
        System.out.println(parentID);
        String childID = itr.next();
        System.out.println(childID);
        driver.switchTo().window(childID);

        driver.close();

        Thread.sleep(01750);

        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setSize(dimension);
        driver.quit();

    }
}
