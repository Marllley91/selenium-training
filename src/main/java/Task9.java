import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class Task9 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\project\\testselenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

        //*Log in*//
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //*Записали страны в переменную *//
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//td[3]"));
        int size = countries.size();

        //*Зайти в список стран и проверить алфавитный порядок зон*//
        for (int i=0; i<size; i++) {
            countries = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//td[3]/a"));
            countries.get(i).click();
            List<WebElement> zone = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]//select[contains(@name,'zones[')]//option[@selected]"));
            int size1 = zone.size();

            List<String> all_countries = new ArrayList<>(); //*Массив будет использоваться, как массив со страницы по дефолту*//
            List<String> all_countries_sort = new ArrayList<>(); //*Массив будет использоваться, как массив с сортировкой*//

            for (int j=0; j<size1; j++) {
                zone = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]//select[contains(@name,'zones[')]//option[@selected]"));
                all_countries.add(zone.get(j).getText());
                all_countries_sort.add(zone.get(j).getText());
                Collections.sort(all_countries_sort);
            }
            //*Проверка алфавитного порядка стран на странице зоны*//
            for (int y=0; y<size1; y++) {
                if (all_countries.get(y).equals(all_countries_sort.get(y))) {
                }
                else {
                    System.out.println("Страны отображены не по алфавиту");
                    break;
                }
            }
            driver.navigate().back();
        }
        driver.quit();
    }

}