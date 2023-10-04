package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {

//        3. Napisati program koji:
//        Ucitava stranicu https://demoqa.com/broken
//        Hvata oba linka sa stranice i
//        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//        Koristan link za citanje status koda nekog url-a

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/broken");

        List<WebElement> links = driver.findElements(By.cssSelector(".row a"));
        for (int i = 0; i < links.size(); i++) {
            int statusCode = getHTTPResponseStatusCode(links.get(i).getAttribute("href"));
            if(statusCode >= 200 && statusCode < 400) {
                System.out.println("Correct status code.");
            } else {
                System.out.println("Incorrect status code.");
            }
        }
        driver.quit();
    }
    public static int getHTTPResponseStatusCode(String u) throws IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
