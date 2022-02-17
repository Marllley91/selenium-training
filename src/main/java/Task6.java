import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Task6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\project\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        //***Log in***//

        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //**Find elements in the left menu**//
        List<WebElement> items = driver.findElements(By.xpath("//td[@id='sidebar']//div[@id='box-apps-menu-wrapper']//li[@id = 'app-']"));
        int size = items.size();

        for (int i=0; i<size; i++) {
            items = driver.findElements(By.xpath("//td[@id='sidebar']//div[@id='box-apps-menu-wrapper']//li[@id = 'app-']"));
            items.get(i).click();
            WebElement title = wait.until(presenceOfElementLocated(By.xpath("//td[@id='content']//h1")));

            boolean isElementPresent = driver.findElements(By.xpath("//td[@id='sidebar']//div[@id='box-apps-menu-wrapper']//li[@id = 'app-' and @class='selected']/ul[@class='docs']/li")).size() > 0;


            if (isElementPresent = true) {
                List<WebElement> items_selected = driver.findElements(By.xpath("//td[@id='sidebar']//div[@id='box-apps-menu-wrapper']//li[@id = 'app-' and @class='selected']/ul[@class='docs']/li"));
                int size1 = items_selected.size();

                for (int j = 0; j<size1; j++){
                    items_selected = driver.findElements(By.xpath("//td[@id='sidebar']//div[@id='box-apps-menu-wrapper']//li[@id = 'app-' and @class='selected']/ul[@class='docs']/li"));
                    items_selected.get(j).click();
                    title = wait.until(presenceOfElementLocated(By.xpath("//td[@id='content']//h1")));

                                    }
            }
        }
        driver.quit();
            }

}




