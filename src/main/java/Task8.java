import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\project\\testselenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

        //***Log in***//
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //*Записали страны и их зоны в переменные *//
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//td[5]"));
        int size = countries.size();
        List<WebElement> zones = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//td[6]"));
        int size1 = zones.size();

        //*Массив с дефолтным набором стран*//
        List<String> all_countries = new ArrayList<>();
        for (int a = 0; a < countries.size(); a++) {
            all_countries.add(countries.get(a).getText());
        }

        //* Массив с отсортированным набором стран*//
        List<String> sort_countries = new ArrayList<>(all_countries);
        Collections.sort(sort_countries);


        //* Сравнение массивов, проверка что страны по алфавиту*//
        for (int b = 0; b < all_countries.size(); b++) {
            if (all_countries.get(b).equals(sort_countries.get(b))) {
            }
            else {
                System.out.println("Список стран НЕ по алфавиту :");
            }
        }

        //*Найти страны, у которых зоны > 0*//
        for (int i=0; i<size1; i++) {
            WebElement zone = zones.get(i);
            String test = zone.getAttribute("textContent");
            if (test.equals("0")) {
            }
            //*Зайти в найденную зону, и проверить, что страны отображены в алфавитном порядке*//
            else {
                zone.findElement(By.xpath("./preceding-sibling::td[1]/a")).click();
                List<WebElement> zone2 = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]"));
                int size2 = zone2.size() - 1;
                List<String> all_elements = new ArrayList<>(); //*Массив будет использоваться, как массив со страницы по дефолту*//
                for (int j=0; j<size2; j++) {
                    zone2 = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]"));
                    all_elements.add(zone2.get(j).getText());
                }
                List<String> all_elements_sort = new ArrayList<>(all_elements); //*Массив будет использоваться, как массив с сортировкой*//
                Collections.sort(all_elements_sort);  //*Сортировка массива*//
                //*Проверка алфавитного порядка стран на странице зоны*//
                for (int y=0; y<size2; y++) {
                    if (all_elements.get(y).equals(all_elements_sort.get(y))) {
                    } else {
                        System.out.println("Страны отображены не по алфавиту");
                        break;
                    }
                }
                driver.navigate().back();
                zones = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//td[6]"));
            }
        }
        driver.quit();
    }
}