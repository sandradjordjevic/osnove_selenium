package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
//        2.Zadatak
//        Napisati program koji ucitava stranicu Zadatak4.html
//        Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url.
//        To je url za get u programu:
//
//        I na stranici vrsi klik na Show in dugme
//        Ceka da se pojavi itbootcamp poruka koristeci explicitni wait

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("file:///C:/Users/Asus/Downloads/Zadatak4.html");
//        driver.findElement(By.id("showInBtn")).click();
//        wait
//                .withMessage("Poruka se nije pojavila za 10s")
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));
//        System.out.println("Prva poruka se pojavila");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
            wait
                    .withMessage(i + 1 + ". poruka se nije pojavila.")
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("id-" + i)));
        }

        driver.quit();

    }
}
