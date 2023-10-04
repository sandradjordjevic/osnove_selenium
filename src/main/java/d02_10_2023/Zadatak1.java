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
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //1.Zadatak

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.findElement(By.cssSelector(".edit-image")).click();
        driver.findElement(By.id("image-option-remove")).click();

        driver.findElement(By.cssSelector(".edit-image")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".sc-llcuoN.hTEWFz"))));
        WebElement input = driver.findElement(By.id("imageUpload"));
        File img1 = new File("C:/Users/Asus/Downloads/1.png");
        input.sendKeys(img1.getAbsolutePath());
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph.dxKPsO .sc-gLDzan.ennWSb"), 1));
        driver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[type = 'submit']"))));
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".edit-image")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".sc-llcuoN.hTEWFz"))));
        input = driver.findElement(By.id("imageUpload"));
        File img2 = new File("C:/Users/Asus/Downloads/2.png");
        input.sendKeys(img2.getAbsolutePath());
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph.dxKPsO .sc-gLDzan.ennWSb"), 2));
        driver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[type = 'submit']"))));
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".edit-image")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".sc-llcuoN.hTEWFz"))));
        input = driver.findElement(By.id("imageUpload"));
        File img3 = new File("C:/Users/Asus/Downloads/3.png");
        input.sendKeys(img3.getAbsolutePath());
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph.dxKPsO .sc-gLDzan.ennWSb"), 3));
        driver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[type = 'submit']"))));
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".edit-image")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".sc-llcuoN.hTEWFz"))));
        input = driver.findElement(By.id("imageUpload"));
        File img4 = new File("C:/Users/Asus/Downloads/4.png");
        input.sendKeys(img3.getAbsolutePath());
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph.dxKPsO .sc-gLDzan.ennWSb"), 4));
        driver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[type = 'submit']"))));
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("textareaID")).sendKeys("text");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(5000);


        driver.quit();
    }
}
