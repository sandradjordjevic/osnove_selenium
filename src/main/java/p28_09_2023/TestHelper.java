package p28_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TestHelper {
    private WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }
    public boolean elementExist (By by) {
        boolean exist = true;
        try {
            driver.findElement(by);
        } catch (Exception e) {
            exist = false;
        }
        return exist;
    }
    public boolean elementExistByList (By by) {
        List<WebElement> lista = driver.findElements(by);
        return lista.size() > 0;
    }
    public void setDefaultImplicitWait () {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void setImplicitWait (int time) {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
