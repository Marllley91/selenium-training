import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class Task13 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\project\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        //***Зайти на главную страницу***//
        driver.navigate().to("http://localhost/litecart/en/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        //***Добавить в корзину первый продукт***//
        List <WebElement> products = driver.findElements(By.xpath("//div[@id='box-most-popular']//li/a[1]"));
        int size = products.size();
        for (int i=0; i<3; i++) {
            products.get(i).click();
            try {
                new Select(driver.findElement(By.name("options[Size]"))).selectByValue("Small");
            }
            catch (Exception ex) {
            }
            driver.findElement(By.name("add_cart_product")).click();
            WebElement quantity = driver.findElement(By.xpath("//div[@id='cart']//a[@class='content']/span[@class='quantity']"));
            Integer expectedQuantity = Integer.parseInt(quantity.getText()) + 1;
            wait.until(ExpectedConditions.textToBePresentInElement(quantity, expectedQuantity.toString()));
            driver.navigate().back();
            products = driver.findElements(By.xpath("//div[@id='box-most-popular']//li/a[1]"));
        }

        //***Перейти в корзину***//
        driver.findElement(By.linkText("Checkout »")).click();
        while (driver.findElements(By.xpath("//button[@name='remove_cart_item']")).size() != 0) {
            WebElement remove_button = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
            remove_button.click();
            wait.until(ExpectedConditions.stalenessOf(remove_button));
        }
        Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("There are no items in your cart."));
        driver.quit();
    }
}


