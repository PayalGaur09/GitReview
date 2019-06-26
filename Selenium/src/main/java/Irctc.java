import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class Irctc {

    @Test
    public void taskAssertion()throws Exception{

        System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.navigate().to("https://www.irctc.co.in");

        String title = driver.getTitle();
        System.out.println("Title :" + title);
        Assert.assertTrue(title.contains("IRCTC Next Generation eTicketing System"));
        WebDriverWait wait= new WebDriverWait(driver,10);

        String url = driver.getCurrentUrl();
        System.out.println("URL: " +url);
        Assert.assertNotEquals("https://www.irctc.co.in", url);
        //Irctc Logo
        WebElement logoRight = driver.findElement(By.xpath("//div[@class=\"h_logo_right_div\"]//img[@class=\"h_logo\"]"));
        Assert.assertNotNull(logoRight);


        //from
        driver.findElement(By.xpath("//input[@placeholder='From*']")).click();
        driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys("NEW DELHI");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NEW DELHI - NDLS']"))).click();

        //To
        driver.findElement(By.xpath("//input[@placeholder='To*']")).click();
        driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys("CHANDIGARH");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='CHANDIGARH - CDG']"))).click();

        //date
        driver.findElement(By.xpath("//span[text()=\"ui-btn\"]/..")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='fa fa-angle-right']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='30'])[2]/..")).click();
        //find train button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Find trains']")).click();

        //Assertion

        Thread.sleep(2000);
        WebElement train = driver.findElement(By.xpath("//a[text()=' TRAINS ']"));
        Assert.assertEquals("All Classes", train.getText());
        System.out.println("We are on the train list page!");

        Thread.sleep(2000);
        WebElement selCls = driver.findElement(By.xpath("//label[@class='ng-tns-c13-17 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
        Assert.assertEquals("All Classes", selCls.getText());
        System.out.println("Journey class is selected");

        Thread.sleep(2000);
        String from = driver.findElement(By.xpath("//div[@class='hidden-xs']//label[contains(text(),'NEW DELHI(NDLS)')]")).getText();
        System.out.println("From station: " +from);
        Assert.assertEquals(from, "NEW DELHI(NDLS)");

        Thread.sleep(2000);
        String toStn = driver.findElement(By.xpath("//div[@class='hidden-xs']//label[contains(text(),'CHANDIGARH(CDG)')]")).getText();
        System.out.println("To station: " +toStn);
        Assert.assertEquals(toStn, "CHANDIGARH(CDG)");

        Thread.sleep(2000);
        String selectDate = driver.findElement(By.xpath("//span[@class=\"t_2_1\"]")).getText();
        System.out.println("Departure Date: " +selectDate);
        Assert.assertEquals(selectDate, "30 Jul");

        //TRAIN LIST VERIFICATION (by converting int to string)
        Thread.sleep(2000);
        int iCount = 0;
        iCount = driver.findElements(By.xpath("//button[text()=\" Check availability & fare \"]")).size();
        String totallist = driver.findElement(By.xpath("//div[@class='col-md-12 hidden-xs']//b")).getText();
        String count=Integer.toString(iCount);
        Assert.assertEquals(totallist,count+" of "+count+" trains found");


       //windo handles: flight
        driver.findElement(By.xpath("//a[text()=\" FLIGHTS \"]")).click();
        Set<String> sessions=driver.getWindowHandles();
        Iterator<String> itr=sessions.iterator();
        // Thread.sleep(10000);
        String parentID=itr.next();
        System.out.println(parentID);
        String childID=itr.next();
        System.out.println(childID);
        driver.switchTo().window(childID);

        //verify the flight page
        String logoName = driver.findElement(By.xpath("//h3[text()='IRCTC AIR']")).getText();
        Assert.assertEquals(logoName, "IRCTC AIR");
        System.out.println();

    }
}
