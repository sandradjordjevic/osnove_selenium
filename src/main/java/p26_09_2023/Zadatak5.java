package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//        Posto ne radi sajt, probajte funkcionalnost checkbox-a
//        na ovom sajtu https://demoqa.com/automation-practice-form
//        Na kraju programa proverite da li je element cekiran.
//        Izguglajte kako mozemo da proverimo da li je element cekiran.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form ");
        Thread.sleep(1000);

        WebElement checkboxLabel = driver.findElement(By.xpath("//label[@for = 'hobbies-checkbox-1']"));
        checkboxLabel.click();
        WebElement inputCheck = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));

        if(inputCheck.isSelected()) {
            System.out.println("Checked");
        } else {
            System.out.println("Not checked");
        }

        driver.quit();
    }
}
