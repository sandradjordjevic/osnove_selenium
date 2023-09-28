package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
//        6. Ucitati stranicu https://google.com
//        Maksimizovati prozor
//        Prostavite dimenzije prozora na 700px i visinu na 700px


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);

        Dimension dimension = new Dimension(700, 700);
        driver.manage().window().setSize(dimension);
        Thread.sleep(2000);

        driver.quit();
    }
}
