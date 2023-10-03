package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//        Uploadujte sliku
//        Ceka se da se pojavi slika u listi uploadovanih fajlova
//        Koristite uslov da broj elemenata bude 1.
//        Klik na Start dugme u okviru item-a koji se uploadovao
//        Ceka se da se pojavi delete dugme pored itema
//        Klik na delete dugme pored itema
//        Ceka se da se element obrise
//        Koristite da broj elemenata bude 0

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        File uploadFile = new File("test_data/10x-featured-social-media-image-size.png");

        WebElement input = driver.findElement(By.cssSelector("input[type='file']"));
        input.sendKeys(uploadFile.getAbsolutePath());
        Thread.sleep(2000);
        List<WebElement> images = driver.findElements(By.xpath("//table[@role='presentation']//tr"));
        System.out.println(images.size());
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@role='presentation']//tr"), 1));
        driver.findElement(By.cssSelector("table .btn.btn-primary.start")).click();
        WebElement btnDelete = driver.findElement(By.cssSelector("table .btn.btn-danger.delete"));
        wait.until(ExpectedConditions.visibilityOf(btnDelete));
        btnDelete.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@role='presentation']//tr"), 0));

        driver.quit();
    }
}
