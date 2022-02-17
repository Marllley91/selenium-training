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
        List<WebElement> items = driver.findElements(By.xpath("//ul[@class='listing-wrapper products']/li[@class='product column shadow hover-light']//div[@class='image-wrapper']"));
        int size = items.size();

        for (int i = 0; i < size; i++) {
            boolean hasSaleSticker = isElementPresent(items.get(i), By.xpath(".//div[@class='sticker sale']"));
            boolean hasNewSticker = isElementPresent(items.get(i), By.xpath(".//div[@class='sticker new']"));

            if (!hasNewSticker && hasSaleSticker) {
                System.out.println("Элемент с лейблом Sale");
            } else if (hasNewSticker && !hasSaleSticker) {
                System.out.println("Элемент с лейблом New");
            } else {
                System.out.println("Элемент имеет два лейбла");
            }

        }

        //    driver.quit();

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





