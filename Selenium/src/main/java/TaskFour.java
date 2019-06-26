import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskFour {
    //HTML page automation
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".//exefiles/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Payal/Downloads/webpage.html");
        WebElement boys = driver.findElement(By.cssSelector("select[name='boys']"));
        Select boysSelect= new Select(boys);
        boysSelect.selectByIndex(3);
        Thread.sleep(500);

        WebElement girls = driver.findElement(By.cssSelector("select[name='girls']"));
        Select girlsSelect= new Select(girls);
        girlsSelect.selectByIndex(1);
        Thread.sleep(500);
        girlsSelect.selectByVisibleText("churi");
        Thread.sleep(500);
        girlsSelect.deselectByIndex(3);
        Thread.sleep(500);
        girlsSelect.deselectByValue("4");
        Thread.sleep(500);
        girlsSelect.deselectByVisibleText("churi");
        Thread.sleep(500);
        girlsSelect.getAllSelectedOptions();
        Thread.sleep(500);
        girlsSelect.deselectAll();

        Thread.sleep(01750);


    }
}
