package libs;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver {
    public static ChromeDriver driver;

    @Before
    public void setUp() {
        System.out.println("Старт теста");
        System.setProperty("webdriver.chrome.driver", "\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void globalSleep(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @After
    public void close() {
        System.out.println("Автотест завершен");
        driver.quit();
    }

}
