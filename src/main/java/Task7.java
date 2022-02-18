import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='image-wrapper']"));
        int size = items.size();

        for (int i = 0; i < size; i++) {
            boolean hasSticker = isElementPresent(items.get(i), By.xpath(".//div[starts-with(@class,'sticker')]"));

            if (hasSticker) {
                System.out.println("Товар № " + i + " имеет один стикер");
            }  else {
                System.out.println("Элемент не имеет стикера");
            }

        }
            driver.quit();
    }
    static boolean isElementPresent(WebElement element, By locator) {
        try {
            element.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}





