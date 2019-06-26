import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Goibibo {

    //method to remove comma

    public Integer makeInt(String s1) {
        StringBuilder sb = new StringBuilder();
        String[] splitted = s1.split(",");
        for (int i = 0; i < splitted.length; i++) {
            sb.append(splitted[i]);
        }
        String withoutComma = sb.toString();
        return Integer.parseInt(withoutComma);
    }

    public static void main(String[] args) throws InterruptedException {

//driver launch
        System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.navigate().to("https://www.goibibo.com/");
        Thread.sleep(2000);

        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Delhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Delhi, India']")).click();

//destination

        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).sendKeys("Mumbai");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Mumbai, India']")).click();
        Thread.sleep(2000);



        driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
        driver.findElement(By.xpath("//div[@id='fare_20190624']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
        driver.findElement(By.xpath("//div[@id='fare_20190628']")).click();
        driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();

        for (int i = 0; i < 1; i++) {

            driver.findElement(By.xpath("//button[@id='adultPaxPlus']")).click();

            Thread.sleep(2000);
        }
        for (int j = 0; j < 2; j++) {
            driver.findElement(By.xpath("//button[@id='childPaxPlus']")).click();
        }



        driver.findElement(By.xpath("//select[@id='gi_class']")).click();
        driver.findElement(By.xpath("//option[@value='B']")).click();
        driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//a[@id='pricesFilter']")).click();

        WebElement e = driver.findElement(By.xpath("//span[text()='Price']"));
        act.moveToElement(e).perform();




        WebElement slider=driver.findElement(By.xpath("//div[@id=\"sliderFO\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
        Goibibo task3=new Goibibo();
// act.clickAndHold(slider);
        for(int i=0;i<=1000;i++) {
            act.dragAndDropBy(slider, -i, 0).perform();
            String s1 = driver.findElement(By.xpath("(//span[@id=\'fareMax\'])[1]")).getText();
            Integer value = task3.makeInt(s1);
            if (value <= 180000) {
                break;
            }
        }

        driver.quit();

    }
}

