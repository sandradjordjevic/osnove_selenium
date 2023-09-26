package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter. Koristan link
//        Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//        Cekanje od 5s
//        Zatvorite pretrazivac

        ArrayList<String> listToDo = new ArrayList<>();
        listToDo.add("Visit Paris");
        listToDo.add("Visit Praque");
        listToDo.add("Visit London");
        listToDo.add("Visit New York");
        listToDo.add("Visit Belgrade");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.cypress.io/todo");
        driver.manage().window().maximize();

        for (int i = 0; i < listToDo.size(); i++) {
            WebElement inputToDo = driver.findElement(By.className("new-todo"));
            inputToDo.clear();
            inputToDo.sendKeys(listToDo.get(i));
            inputToDo.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

        }

        List <WebElement> tasks = driver.findElements(By.cssSelector("ul.todo-list>li"));
        for(int i = 0; i < tasks.size(); i++) {
            tasks.get(i).findElement(By.className("toggle")).click();
            Thread.sleep(2000);
        }
        Thread.sleep(5000);


        driver.quit();

    }
}
