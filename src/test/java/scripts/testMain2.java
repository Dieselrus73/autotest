package scripts;

import libs.webDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class testMain2 extends webDriver {

    @Test
    public void testPage() throws InterruptedException, IOException {
        ChromeDriver d = driver;
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /////
        String url = "https://google.com";
        /////
        d.get(url);
        globalSleep(5);

        WebElement searchInput = d.findElement(By.xpath("//input[@title='Поиск']"));
        String fileName = "in.txt";
        Optional<String> line = Files.lines(Paths.get(fileName)).findFirst();
        System.out.println(line.get());
        String readText = line.get();

        searchInput.sendKeys(readText);
        globalSleep(5);

        WebElement clickSearchBtn = d.findElement(By.xpath("//input[@name='btnK']"));
        clickSearchBtn.click();
        globalSleep(5);
        System.out.println("Мы находимся на странице \"Окей Гугл\"");

        d.get(url);
        globalSleep(5);

        WebElement searchInputNoGoogle = d.findElement(By.xpath("//input[@title='Поиск']"));
        searchInputNoGoogle.sendKeys("Я не Гугл");
        globalSleep(5);

        WebElement clickSearchBtnNoGoogle = d.findElement(By.xpath("//input[@name='btnK']"));
        clickSearchBtnNoGoogle.click();
        globalSleep(5);

        try {
            WebElement title = d.findElement(By.xpath("//*[contains(text(), 'Окей гугл')]"));
            System.out.println("Мы находимся на нужной странице");
            File file = new File("out.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Мы находимся на нужной странице");
            writer.flush();
            writer.close();
        } catch (Exception error) {
            System.out.println("Мы находимся на другой странице");
            File file = new File("error.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Мы находимся на другой странице");
            writer.flush();
            writer.close();

            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss");
            String path = "screenshot\\" + formatForDateNow.format(dateNow)+".png";

            try {
                FileUtils.copyFile(screenshot, new File(path));
            } catch (IOException e) {

            }


        }

    }
}
