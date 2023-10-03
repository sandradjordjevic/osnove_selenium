package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.io.FileHandler;

public class Zadatak6 {
    public static void main(String[] args) {
//        Zadatak (za vezbanje)
//        Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots po imenom
//        screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
//        Koristan link https://www.javatpoint.com/java-date-to-string

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(" https://google.com");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String dateAndTime = dateFormat.format(date);

        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("screenshots/screenshot-" + dateAndTime + ".jpg"));
        } catch (Exception e) {

        }

        driver.quit();
    }
}
