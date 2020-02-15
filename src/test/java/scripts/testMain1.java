package scripts;

import libs.webDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testMain1 extends webDriver {
    @Test
    public void testPage() throws InterruptedException {
        ChromeDriver d = driver;
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /////
        String url = "https://google.com";
        /////
        d.get(url);
        globalSleep(5);

        WebElement searchInput = d.findElement(By.xpath("//input[@title='Поиск']"));
        searchInput.sendKeys("Окей Гугл");
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
            System.out.println("Мы на нужной странице ");
        } catch (Exception error) {
            System.out.println("Мы находимся на другой странице ");
        }

    }
}
