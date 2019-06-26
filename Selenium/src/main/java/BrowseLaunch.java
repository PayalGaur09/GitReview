
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowseLaunch {
    public static void main(String[] args) throws InterruptedException {

       System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();

        driver.quit();


    }

}

