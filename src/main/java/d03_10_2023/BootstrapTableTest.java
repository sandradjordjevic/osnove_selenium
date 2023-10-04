package d03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;
import java.util.List;

public class BootstrapTableTest {
    private String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx ";
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod () {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
        wait.until(ExpectedConditions.titleContains("Table with Edit and Update Data - Bootsnipp.com"));
    }
    @Test
    public void editRow () throws InterruptedException {
        String firstName = "Sandra";
        String lastName = "Djordjevic";
        String middleName = "Sasa";

        driver.findElement(By.cssSelector("tr#d1 button.update")).click();
        wait    .withMessage("Edit dialog is not visible")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#edit .modal-dialog")));
        WebElement inputFirstName = driver.findElement(By.cssSelector("div#edit .modal-dialog #fn"));
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        WebElement inputLastName = driver.findElement(By.cssSelector("div#edit .modal-dialog #ln"));
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        WebElement inputMiddleName = driver.findElement(By.cssSelector("div#edit .modal-dialog #mn"));
        inputMiddleName.clear();
        inputMiddleName.sendKeys(middleName);
        driver.findElement(By.cssSelector("div.modal-footer #up")).click();
        wait    .withMessage("Edit dialog is still visible.")
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div#edit .modal-dialog"))));
        Assert.assertEquals(inputFirstName.getAttribute("value"), firstName, "The entered value is not found in the input for first name.");
        Assert.assertEquals(inputLastName.getAttribute("value"), lastName, "The entered value is not found in the input for last name.");
        Assert.assertEquals(inputMiddleName.getAttribute("value"), middleName, "The entered value is not found in the input for middle name.");
    }
    @Test
    public void deleteRow () throws InterruptedException {
        int numberOfTrBeforeDeleting = driver.findElements(By.cssSelector("tbody tr")).size();
        driver.findElement(By.cssSelector("tr#d1 button.delete")).click();
        wait    .withMessage("Delete dialog is not visible.")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#delete .modal-dialog")));
        driver.findElement(By.cssSelector("div#delete .modal-dialog #del")).click();
        wait    .withMessage("Delete dialog is still visible.")
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div#delete .modal-dialog"))));

        int numberOfTrAfterDeleting = driver.findElements(By.cssSelector("tbody tr")).size();
        Assert.assertTrue(numberOfTrBeforeDeleting != numberOfTrAfterDeleting, "The row is not deleted.");
    }
    @Test
    public void takeAScreenshot () {
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("screenshots/img.jpg"));
        } catch (Exception e) {

        }
    }
    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
