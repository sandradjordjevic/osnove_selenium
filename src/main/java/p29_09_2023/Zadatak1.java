package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        1.Zadatak
//        Napisati program koji ucitava stranicu
//        https://s.bootsnipp.com/iframe/klDWV i ceka da se ucita progress bar na 100%
//        // a zatim ispisuje tekst u konzoli “Stranica ucitana”

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://s.bootsnipp.com/iframe/klDWV");
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector(".preloader-wrap #precent")), "100%"));
        System.out.println("Stranica je ucitana.");

        driver.quit();
    }
}
