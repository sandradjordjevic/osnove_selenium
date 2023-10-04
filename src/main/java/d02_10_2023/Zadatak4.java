package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException, IOException {
//        4. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i
//        jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://itbootcamp.rs/");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".owl-stage")));
        Thread.sleep(1000);
        List<WebElement> images = driver.findElements(By.cssSelector(".carousel-item img"));
        for (int i = 0; i < images.size(); i++) {
            int statusCode = getHTTPResponseStatusCode(images.get(i).getAttribute("src"));
            System.out.println(statusCode);
            if (statusCode >= 200 && statusCode < 300) {
                try {
                    downloadUsingNIO(images.get(i).getAttribute("src"), "itbootcamp_slider/img" + i + ".png");
                } catch (Exception e) {

                }
            }
        }
        driver.quit();
    }
    public static int getHTTPResponseStatusCode(String u) throws IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}
