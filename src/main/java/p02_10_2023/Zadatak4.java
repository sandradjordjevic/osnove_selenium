package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import org.openqa.selenium.io.FileHandler;


public class Zadatak4 {
    public static void main(String[] args) {
//        Napisati program koji:
//        Kreirati screenshots folder u projektu
//        Ucitava stranicu https://google.com
//        Kreira screenshot stranice
//        Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//        Koristan link 1. LAKSE CE VAM BITI PREKO OVOG
//        Koristan link 2
//        Koristan link 3

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("screenshots/screenshot.jpg"));
        } catch (Exception e) {

        }
        driver.quit();
    }
}
