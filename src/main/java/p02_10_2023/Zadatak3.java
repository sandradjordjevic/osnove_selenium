package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
//        Napisati program koji
//        Kreirati folder downloads folder u projektu
//        URL SLIKE https://cdn.britannica.com/29/150929-050-547070A1/lion-Kenya-Masai-Mara-National-Reserve.jpg
//        Sliku sacuvajte u folderu downloads pod nazivom ljuti-lav.jpg
//        Koristan link za skidanje fajlova u javi
//        Azurirajte gitignore da ignorise downloads folder


        String url = "https://cdn.britannica.com/29/150929-050-547070A1/lion-Kenya-Masai-Mara-National-Reserve.jpg";
        String path = "downloads/ljuti-lav.jpg";

        Helper.downloadUsingStream(url, path);


    }
}
