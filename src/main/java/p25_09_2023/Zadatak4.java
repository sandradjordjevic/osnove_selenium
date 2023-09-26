package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//        4. Zadatak
//        Napisati program koji:
//        Maksimizuje stranicu
//        Ucitava stranicu https://demoqa.com/webtables
//        Vrsi klik na edit dugme prvog reda
//        Unosi informacije za sva polja u edit formi
//        Klik na submit
//        Ceka par sekundi
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.cssSelector("span#edit-record-1")).click();

        driver.findElement(By.cssSelector("input#firstName")).clear();
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("Sandra");
        driver.findElement(By.cssSelector("input#lastName")).clear();
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("Djordjevic");
        driver.findElement(By.cssSelector("input#userEmail")).clear();
        driver.findElement(By.cssSelector("input#userEmail")).sendKeys("sandradj@gmail.com");
        driver.findElement(By.cssSelector("input#age")).clear();
        driver.findElement(By.cssSelector("input#age")).sendKeys("26");
        driver.findElement(By.cssSelector("input#salary")).clear();
        driver.findElement(By.cssSelector("input#salary")).sendKeys("10000");
        driver.findElement(By.cssSelector("input#department")).clear();
        driver.findElement(By.cssSelector("input#department")).sendKeys("Insurance");
        driver.findElement(By.cssSelector("button#submit")).click();

        Thread.sleep(2000);
        driver.quit();


    }
}
