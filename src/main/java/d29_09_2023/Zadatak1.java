package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Napisati program koji testira infinity scroll.
//        Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//        Selektujte delay od 2000ms, koristeci Select klasu.
//        Skrol do Show more dugmeta koje se nalazi na dnu stranice
//        Sacekajte da dugme bude klikljivo
//        Klik na Show more dugme
//        Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//        Sacekajte da dugme vise ne bude klikljivo

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        Select selectDelay = new Select(driver.findElement(By.id("delay-select")));
        selectDelay.selectByValue("2000");
        Thread.sleep(1000);
        WebElement btnShow = driver.findElement(By.cssSelector("button#infinite-scroll-button"));
        WebElement lastChild = driver.findElement(By.xpath("//div[@class='item'][last()]"));
        WebElement child3 = driver.findElement(By.xpath("//div[@class='item'][3]"));
        WebElement footer = driver.findElement(By.cssSelector("div.footer"));
        js.executeScript("arguments[0].scrollIntoView();", child3);
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", footer);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(btnShow));
        btnShow.click();
        List<WebElement> items = driver.findElements(By.cssSelector("div.item"));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.item"), items.size()));
        WebElement disabledBtn = driver.findElement(By.cssSelector("button#infinite-scroll-button span.disabled-text"));
        wait.until(ExpectedConditions.visibilityOf(disabledBtn));
        Thread.sleep(1000);

        driver.quit();
    }
}
