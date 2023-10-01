package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Napisati program koji:
//        Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//        Implicitno cekanje za trazenje elemenata je maksimalno 10s
//        Implicitno cekanje za ucitavanje stranice je 5s
//        Ucitava stranicu https://docs.katalon.com/
//        Maksimizuje prozor
//        Od html elementa cita data-theme atribut.
//                Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//        Klikce na dugme za zamenu tema
//        Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//        Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//        Ceka da se dijalog za pretragu pojavi
//        Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://docs.katalon.com/");
        String theme = driver.findElement(By.tagName("html")).getAttribute("data-theme");
        System.out.println(theme);
        if(theme.equals("light")) {
            System.out.println("Light theme.");
        } else {
            System.out.println("Dark theme.");
        }
        driver.findElement(By.cssSelector("button.clean-btn.toggleButton_rCf9")).click();
        Thread.sleep(1000);

        theme = driver.findElement(By.tagName("html")).getAttribute("data-theme");
        System.out.println(theme);
        if(theme.equals("dark")) {
            System.out.println("Dark theme.");
        } else {
            System.out.println("Light theme.");
        }

        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".DocSearch-Modal"))));
        String inputSearch = driver.findElement(By.id("docsearch-input")).getAttribute("type");
        if(inputSearch.equals("search")) {
            System.out.println("Value is search");
        } else {
            System.out.println("Value is not search");
        }

        driver.quit();
    }
}
