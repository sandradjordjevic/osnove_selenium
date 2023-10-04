package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        2. Zadatak
//        Napisati program koji:
//        Ucitava stranu https://itbootcamp.rs/
//        Misem prelazi preko Vesti iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Vesti
//        Misem prelazi preko Kursevi iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Kursevi
//        Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Prijava i pravilnik
//        Koristan link. Mouse over preko seleniuma
//        https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        WebElement linkVesti = driver.findElement(By.cssSelector("li#menu-item-6408 a"));
        new Actions(driver).moveToElement(linkVesti).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#menu-item-6408 ul"))));

        WebElement linkKursevi = driver.findElement(By.cssSelector("#menu-item-5362"));
        new Actions(driver).moveToElement(linkKursevi).perform();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#menu-item-5362 ul"))));

        WebElement linkPrijava = driver.findElement(By.cssSelector("#menu-item-5453"));
        new Actions(driver).moveToElement(linkPrijava).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#menu-item-5453 ul"))));


        driver.quit();
    }
}
