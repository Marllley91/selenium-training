import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\project\\testselenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        //***Log in***//
        driver.navigate().to("http://localhost/litecart/en/");
        List<WebElement> items = driver.findElements(By.xpath("//ul[@class='listing-wrapper products']/li")); //***Найти товары и поместить в items***//
        int size = items.size();
        System.out.println("Наличие товаров на странице: " + size);

        //***Убедиться, что какждый товар содержит ровно один стикер***//
        for (WebElement  i : items) {
            List<WebElement> test = i.findElements(By.xpath(".//div[contains(@class,\"sticker\")]"));
            System.out.println("Товар содержит " + test.size() + " стикер(ов)");
        }

        driver.quit();
    }

}





