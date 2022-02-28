import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Date;

public class Task11 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\project\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

        //***Зайти на главную страницу***//
        driver.navigate().to("http://localhost/litecart/en/");

        //***Открыть форму регистрации***//
        driver.findElement(By.linkText("New customers click here")).click();

        //***Заполнение полей формы регистрации***//
        driver.findElement(By.xpath("//input[@name='tax_id']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Test_user_company");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ivan");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ivanov");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Test distr.");
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Los Angeles");

        //***Выбор страны и зоны***//
        driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("United States"+ Keys.ENTER);
        Select zone = new Select(driver.findElement(By.xpath("//select[@name='zone_code']")));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].selectedIndex=11", zone);
        javascriptExecutor.executeScript("arguments[0].selectedIndex=11;arguments[0].dispatchEvent(new Event('change'));", zone);
        //******//


        String email = new Date().getTime() + "@example.ru";
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+177889955");
        String password = "111";
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='create_account']")).click();
        driver.findElement(By.xpath("//div[@id='box-account']/div[@class='content']/ul/li[last()]/a")).click();

        //***Повторный логин***//
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.findElement(By.xpath("//div[@id='box-account']/div[@class='content']/ul/li[last()]/a")).click();

        driver.quit();
    }

}
