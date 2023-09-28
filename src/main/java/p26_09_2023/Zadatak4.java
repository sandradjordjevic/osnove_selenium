package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.ebay.com/");
        Thread.sleep(1000);

        WebElement select = driver.findElement(By.id("gh-cat"));
        Select s = new Select(select);
        s.selectByVisibleText("Crafts");
        Thread.sleep(2000);


        driver.quit();

    }
}
