import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        String date = null;
        int daysCount = 7;
        int daysShiftCount = 3;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver ();
        driver.get("https://www.booking.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        element.sendKeys("Paris");
        element = driver.findElement(By.xpath("//*[contains(@class, \"xp__input-group xp__date-time\")]"));
        element.click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysShiftCount);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, daysCount);
        Date sevenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusSevenDays = dateFormat.format(sevenDays);

        element = driver.findElement(By.xpath(String.format("//*[contains(@data-date, \"%s\")]", datePlusThreeDays)));
        element.click();
        element = driver.findElement(By.xpath(String.format("//*[contains(@data-date, \"%s\")]", datePlusSevenDays)));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]"));
        element.click();

        element = driver.findElement(By.xpath("//*[contains(@class,\"field-adult\")]//input"));
        String adultCount = element.getAttribute("value");
        element = driver.findElement(By.xpath("//*[contains(@aria-describedby, \"adult\")][contains(@class, \"add\")]"));
        for (int i = 0; i < (4 - Integer.parseInt(adultCount)); i++) {
            element.click();
        }

        element = driver.findElement(By.xpath("//*[contains(@class,\"field-rooms\")]//input"));
        String roomCount = element.getAttribute("value");
        System.out.println(roomCount);
        element = driver.findElement(By.xpath("//*[contains(@aria-describedby, \"no_rooms_desc\")][contains(@class, \"add\")]"));
        for (int i = 0; i < (2 - Integer.parseInt(roomCount)); i++) {
            element.click();
        }
        element = driver.findElement(By.xpath("//*[contains(@type, \"submit\")]"));
        element.click();
        TimeUnit.SECONDS.sleep(4);

        element = driver.findElement(By.xpath("//*[contains(@class, \"sort_price\")]/a"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"filter_price\"]//a[5]"));
        element.click();
        String maxPrice = element.getText();
        maxPrice = maxPrice.replaceAll("\\D+", "");
        TimeUnit.SECONDS.sleep(2);

        element = driver.findElement(By.xpath("//*[contains(@class, \"bui-price-display\")]/div[2]/div"));
        String firstPrice = element.getText();
        driver.close();
        firstPrice = firstPrice.replaceAll("\\D+", "");
        int firstOneDayPrice = Integer.parseInt(firstPrice) / daysCount;
        System.out.println(firstOneDayPrice +" "+maxPrice);
        Assert.assertTrue(firstOneDayPrice >= Integer.parseInt(maxPrice));
    }
}
