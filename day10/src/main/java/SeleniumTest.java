import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    static WebDriver driver = new ChromeDriver ();

    public static void main(String[] args) {
        List <WebElement> el2;
        System.setProperty ("webdriver.chrome.driver", "D:\\QA");
        driver.get ("https://google.com/");

        WebElement el = driver.findElement (By.name ("q"));
        el.sendKeys ("погода минск");

//        el2 = driver.findElements (By.name("btnK"));
//        el2.get (1).click ();


//        System.out.println (driver.getCurrentUrl ());
//        System.out.println (driver.getTitle ());
//        driver.navigate ().to ("https://yandex.ru");
//        driver.navigate ().back ();
//        driver.navigate ().refresh ();
//        driver.close ();
//        driver.quit ();
//


    }
}
