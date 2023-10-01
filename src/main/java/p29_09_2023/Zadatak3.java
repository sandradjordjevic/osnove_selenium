package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        4.Zadatak
//        Napisati program koji
//        ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik Primary dugme
//        Ceka da se pojavi toasts u gornjem desnom uglu
//        Ispisuje da se element pojavio
//        Ceka da se izgubi toasts u gornjem desnom uglu
//        Ispisuje da se elment izgubio
//        Klik na primary dugme
//        Ceka da se pojavi toasts u gornjem desnom uglu
//        Ispisuje da se element pojavio
//        Klik na x dugme iz toasts-a
//        Ceka da se element izgubi
//        Ispisuje da se element izgubio

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");


        WebElement btnPrimary = driver.findElement(By.id("basic-primary-trigger"));
        Thread.sleep(2000);
        btnPrimary.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast.fade.mx-auto.toast-primary.toast-fixed.hide")));
        System.out.println("Element se pojavio.");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast.fade.mx-auto.toast-primary.toast-fixed.hide"))));
        System.out.println("Element se izgubio.");
        btnPrimary.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast.fade.mx-auto.toast-primary.toast-fixed.hide")));
        System.out.println("Element se pojavio.");

        driver.findElement(By.cssSelector("#basic-primary-example .btn-close")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast.fade.mx-auto.toast-primary.toast-fixed.hide"))));
        System.out.println("Element se izgubio.");

        Thread.sleep(2000);
        driver.quit();
    }
}
