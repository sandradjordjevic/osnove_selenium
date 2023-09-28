package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        2.Zadatak
//        Napisti program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//        Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa
//        procitamo tekst imate na sledecem linku
//        Ceka 1s
//        Hvata sve elemente prvog reda i stampa tekst svakog elementa
//        Ceka 5s
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(2000);

        List<WebElement> col1Elements = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr/td[1]"));
        for(int i = 0; i < col1Elements.size(); i++) {
            System.out.println(col1Elements.get(i).getText());
        }
        Thread.sleep(1000);
        List<WebElement> row1Elements = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr[1]/td"));
        for(int i = 0; i < col1Elements.size(); i++) {
            System.out.println(row1Elements.get(i).getText());
        }
        driver.quit();
    }
}
