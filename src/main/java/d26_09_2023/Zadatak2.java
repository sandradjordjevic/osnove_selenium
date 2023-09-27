package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se
//        nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//        POMOC: Brisite elemente odozdo.
//        (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(2000);

        List<WebElement> tasks = driver.findElements(By.cssSelector(".col-md-12 > div"));
        System.out.println(tasks.size());
        //Brisanje odozdo
//        for (int i = tasks.size() - 1; i >= 0; i--) {
//            int tasksSize = tasks.size();
//            tasks.get(i).findElement(By.className("close")).click();
//            tasks = driver.findElements(By.cssSelector(".col-md-12 > div"));
//            if (tasksSize - tasks.size() == 1) {
//                System.out.println("Deleted");
//            } else {
//                System.out.println("Not deleted");
//            }
//            Thread.sleep(1000);
//
//        }
        //Brisanje odozgo
        for(int i = 0; i < tasks.size(); i++) {
            int tasksSize = driver.findElements(By.cssSelector(".col-md-12 > div")).size();
            tasks.get(i).findElement(By.className("close")).click();
            List<WebElement> tasks1 = driver.findElements(By.cssSelector(".col-md-12 > div"));
            if (tasksSize - tasks1.size() == 1) {
                System.out.println("Deleted");
            } else {
                System.out.println("Not deleted");
            }
            Thread.sleep(1000);
        }
        Thread.sleep(2000);

        driver.quit();
    }
}
