package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonLoginTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to("https://cms.demo.katalon.com");
    }
    @Test
    public void visitLoginPageFromNavBar() {
        driver.findElement(By.cssSelector(".page_item.page-item-10 a")).click();
        Assert.assertEquals(driver.getTitle(), "My account – Katalon Shop", "The title of the page isn't My account – Katalon Shop.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "/my-account doesn't appear in the url of the page");
    }
    @Test
    public void checkInputTypes () {
        driver.navigate().to("https://cms.demo.katalon.com/my-account/");
        Assert.assertEquals(driver.findElement(By.id("username")).getAttribute("type"), "text", "Attribute type doesn't have value text.");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("type"), "password", "Attribute type doesn't have value password.");
        Assert.assertEquals(driver.findElement(By.id("rememberme")).getAttribute("type"), "checkbox", "Attribute type doesn't have value checkbox.");
        Assert.assertFalse(driver.findElement(By.id("rememberme")).isSelected());
    }
    @Test
    public void displayErrorWhenCredentialsAreWrong () {
        driver.findElement(By.cssSelector(".page_item.page-item-10 a")).click();
        driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("invalid123");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".woocommerce-error")).isDisplayed(), "Error element is visible.");
        Assert.assertTrue(driver.findElement(By.cssSelector(".woocommerce-error li")).getText().contains("Invalid email address"), "Message don't contain valid text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Not on the log in page.");
    }
    @Test
    public void  successfulLoginWithValidCredentials() {
        driver.findElement(By.cssSelector(".page_item.page-item-10 a")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        wait    .withMessage("Log out link doesn't appear.")
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log out")));
    }
    @AfterClass
    public void afterClass () {
        driver.quit();
    }

}
