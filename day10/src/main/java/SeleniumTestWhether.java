import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestWhether {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver ();
        driver.get("http://google.com");

        driver.findElement(By.name("q")).sendKeys("Погода Минск");
        driver.findElement(By.xpath("//div[@id='lga']")).click();
        driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[contains(@value,'Google')]")).click();
        driver.findElement(By.xpath("//div[@class='wob_df'][1]")).click();
        String day = driver.findElement(By.xpath("//*[@id='wob_dp']/div[2]/div[@class='vk_lgy']")).getAttribute("aria-label");
        String time = "12:00";
        String scale = "Celsius";
        String weatherInfo = "//*[contains(@aria-label, '%s %s') and contains(@aria-label, '%s')][1]";
        String tomorrowWeather = driver.findElement(By.xpath(String.format(weatherInfo, day, time, scale))).getAttribute("aria-label");
        String MSG = "Tomorrow weather forecast for Minsk at %s is %s%s";
        System.out.print(String.format(MSG, time, tomorrowWeather.substring(0, tomorrowWeather.indexOf("C")), scale.substring(0, 1)));
        driver.quit();

    }
}
