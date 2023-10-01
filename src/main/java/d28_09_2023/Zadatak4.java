package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//        4.Zadatak
//        Ucitati stranicu http://seleniumdemo.com/?post_type=product
//        Klik na search dugme u gornjem desnom uglu
//        Cekati da forma za pretragu bude vidljiva
//        Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//        Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu.
//        Ispisati odgovarajuce poruke u terminalu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://seleniumdemo.com/?post_type=product");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".topbar-nav__utils ul li:nth-child(1) a")).click();
        wait    .withMessage("Input is not visible in 10s.")
               .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search__wrapper")));
        driver.findElement(By.id("s-651536d633c09")).sendKeys("BDD Cucumber");
        driver.findElement(By.id("s-651536d633c09")).sendKeys(Keys.ENTER);

        driver.get("http://seleniumdemo.com/?s=BDD+Cucumber");
        WebElement h2Title = driver.findElement(By.cssSelector("#content article:nth-child(1) .entry-title"));
        if(h2Title.getText().equals("BDD Cucumber")) {
            System.out.println("Correct.");
        } else {
            System.out.println("Incorrect.");
        }

        driver.quit();
    }
}
