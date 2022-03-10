import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class Task17 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\project\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

        //***Log in***//
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //***Количество товаров в таблице***//
        List<WebElement> products_in_a_table = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]/a"));
        int size = products_in_a_table.size();

        //***Добавить продукты в массив***//
        List <String> products = new ArrayList<String>();
        for (int i = 0; i < products_in_a_table.size(); i++) {
            products_in_a_table = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]/a"));
            products.add(products_in_a_table.get(i).getText());
        }

        //***Зайти в товар и вернуться обратно, проверить, не появляются ли в логе браузера сообщения***//
        for (String product : products) {
            driver.findElement(By.linkText(product)).click();
            driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
            driver.navigate().back();
        }
        driver.quit();
    }
}

