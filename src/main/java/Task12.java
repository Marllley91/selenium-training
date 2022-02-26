import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static java.lang.Thread.sleep;

public class Task12 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\project\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

        //***Зайти на главную страницу***//
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //***Добавление нового продукта на странице General***//
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.xpath("//input[@type='radio' and @value=1]")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value=1]")).click();
        driver.findElement(By.xpath("//input[@name = 'name[en]']")).sendKeys("Product_name_test");
        driver.findElement(By.xpath("//input[@name = 'code']")).sendKeys("Code_test");
        Select d_category = new Select(driver.findElement(By.xpath("//select[@name='default_category_id']")));
        d_category.selectByVisibleText("Rubber Ducks");
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='1-1']")).click();
        driver.findElement(By.xpath("//input[@name = 'quantity']")).clear();
        driver.findElement(By.xpath("//input[@name = 'quantity']")).sendKeys("2");
        File upload = new File("donald-duck.png");
        String absolute = upload.getAbsolutePath();
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(absolute);
        driver.findElement(By.xpath("//input[@type='date' and @name='date_valid_from']")).clear();
        driver.findElement(By.xpath("//input[@type='date' and @name='date_valid_from']")).sendKeys("01.02.2022");
        driver.findElement(By.xpath("//input[@type='date' and @name='date_valid_to']")).clear();
        driver.findElement(By.xpath("//input[@type='date' and @name='date_valid_to']")).sendKeys("31.03.2022");

        //***Добавление нового продукта на странице Information***//
        driver.findElement(By.linkText("Information")).click();
        sleep (1000);
        Select manufacturer = new Select(driver.findElement(By.xpath("//select[@name='manufacturer_id']")));
        manufacturer.selectByVisibleText("ACME Corp.");
        driver.findElement(By.xpath("//input[@name='keywords']")).sendKeys("Keywords_test");
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("Description_test");
        driver.findElement(By.xpath("//div[@class='trumbowyg-editor']")).sendKeys("Description_test");
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys("Head_title_test");
        driver.findElement(By.xpath("//input[@name='meta_description[en]']")).sendKeys("Meta_description_test");

        //***Добавление нового продукта на странице Prices***//
        driver.findElement(By.linkText("Prices")).click();
        sleep (1000);
        driver.findElement(By.xpath("//input[@name = 'purchase_price']")).clear();
        driver.findElement(By.xpath("//input[@name = 'purchase_price']")).sendKeys("25");
        Select currency = new Select(driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")));
        currency.selectByVisibleText("US Dollars");
        driver.findElement(By.xpath("//button[@name='save']")).click();
        driver.navigate().to("http://localhost/litecart/en/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        sleep (1000);

   driver.quit();
    }
}
