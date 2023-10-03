package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//        U folder skinite i postavite proizvoljnu sliku
//        Ucitava stranu https://tus.io/demo.html
//        Skrola do dela za upload fajla
//        Aploadujte sliku
//        Cekajte da se pojava dugme za download fajla

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(" https://tus.io/demo.html");
        Thread.sleep(1000);
        WebElement elements = driver.findElement(By.cssSelector("._root_gq6c0_1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
        File uploadFile = new File("test_data/10x-featured-social-media-image-size.png");

        driver.findElement(By.id("P0-0")).sendKeys(uploadFile.getAbsolutePath());
        WebElement btn = driver.findElement(By.cssSelector("._buttons_gq6c0_28 a"));
        wait    .withMessage("Dugme nije vidljivo.")
                .until(ExpectedConditions.visibilityOf(btn));



        driver.quit();

    }
}
