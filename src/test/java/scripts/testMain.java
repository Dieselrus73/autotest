package scripts;

import libs.webDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
// открытие сайта гугл
public class testMain extends webDriver {

    @Test
    public void testPage() throws InterruptedException {
        ChromeDriver d = driver;
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /////
        String url = "https://google.com";
        /////
        d.get(url);
        globalSleep(10);

    }

}
