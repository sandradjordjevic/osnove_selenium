package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws IOException {
//        Napisati program koji:
//        Ucitava stranicu https://demoqa.com/broken
//        Hvata oba linka sa stranice i
//        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//        Koristan link za citanje status koda nekog url-a
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/broken");
        List<WebElement> links = driver.findElements(By.cssSelector(".row a"));
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            int statusCode = UrlHelpers.getHTTPResponseStatusCode(links.get(i).getAttribute("href"));
            if(statusCode >= 200 && statusCode < 400) {
                System.out.println("Valid status code.");
            } else {
                System.out.println("Invalid status code.");
            }
        }

        driver.quit();
    }

}
