import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstClass {
    public static void main(String[] args)  {
        System.setProperty("webdriver.gecko.driver", "C:\\project\\testselenium\\drivers\\geckodriver.exe");

            WebDriver driver = new FirefoxDriver();
            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.manage().window().maximize();
            driver.navigate().to ("http://localhost/litecart/admin");

            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();
            wait.until(titleIs("My Store"));

            driver.quit();
    }
}
