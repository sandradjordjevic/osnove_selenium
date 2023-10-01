package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        1.Zadatak
//        Napisati program koji ucitava stranicu
//        https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//        Klik na Type drawdown
//        Klik na Public iz drowdowna
//        Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//        Kilk na Clear filter u desnom uglu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        Thread.sleep(3000);
        driver.findElement(By.id("type-options")).click();
        driver.findElement(By.cssSelector(".SelectMenu-list label:nth-child(2)")).click();
        wait    .withMessage("Button 'close' did not appear for 10s.")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".TableObject-item.text-right.v-align-top")));
        driver.findElement(By.cssSelector(".TableObject-item.text-right.v-align-top")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
