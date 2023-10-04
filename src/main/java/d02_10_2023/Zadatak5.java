package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//        5.Zadatak (za vezbanje)
//        Napisati program koji:
//        Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//        Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//        Ceka da se prikazu 4 item-a a upload
//        Klik na upload
//        Ceka da se upload zavrsi

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        WebElement input = driver.findElement(By.name("files[]"));
        File img1 = new File("C:/Users/Asus/Downloads/women.jpg");
        File img2 = new File("C:/Users/Asus/Downloads/github1.png");
        File img3 = new File("C:/Users/Asus/Downloads/github2.png");
        File img4 = new File("C:/Users/Asus/Downloads/linkedin.png");

        input.sendKeys(img1.getAbsolutePath() + "\n" + img2.getAbsolutePath() + "\n" + img3.getAbsolutePath() + "\n" + img4.getAbsolutePath());
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr.image"), 4));
        driver.findElement(By.cssSelector("div.col-lg-7 button.start")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody.files tr button.delete"), 4));

        driver.quit();
    }
}
