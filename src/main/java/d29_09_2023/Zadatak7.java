package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak7 {
    public static <IJavaScriptExecutor> void main(String[] args) throws InterruptedException {

//        7. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://tus.io/demo.html
//        Hvata sve linkove sa stranice
//        Skrola do svakog h3 elementa
//        Od svakog h3 elementa cita text
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");

        List<WebElement> links = driver.findElements(By.cssSelector("link"));
        List<WebElement> h3Elements = driver.findElements(By.xpath("//body//h3"));

        for (int i = 0; i < h3Elements.size(); i++) {
            WebElement h3Element = driver.findElement(By.xpath("//h3[" + (i + 1) + "]"));
            wait.until(ExpectedConditions.visibilityOf(h3Element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", h3Element);
            Thread.sleep(1000);
        }

        for (int i = 0; i < h3Elements.size(); i++) {
            System.out.println(h3Elements.get(i).getText());
        }



        driver.quit();
    }
}
