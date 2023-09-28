package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        3.Zadatak
//        Napisti program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//        Hvata sve elemente iz tabele i stampa tekst svakog elementa.
//        Kako da od nekog elementa procitamo tekst imate na sledecem linku
//        Ceka 5s
//        Zatvara pretrazivac
//        Stampa treba da bude kao u primeru:
//        John	Doe	john@example.com
//        Mary	Moe	mary@example.com
//        July	Dooley	july@example.com
//
//        HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr"));
        for (int i = 0; i < rows.size(); i++) {
            Thread.sleep(1000);
            List<WebElement> tds = rows.get(i).findElements(By.cssSelector("td"));
            for(int j = 0; j < tds.size(); j++) {
                if(j < tds.size() - 1) {
                    System.out.print(tds.get(j).getText() + " ");
                    Thread.sleep(1000);
                } else {
                    System.out.println(tds.get(j).getText());
                }
            }
        }
        driver.quit();
    }
}
