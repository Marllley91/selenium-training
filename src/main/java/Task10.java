import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task10 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\project\\testselenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        String result;
        //*Зайти на главную страницу*//
        driver.get("http://localhost/litecart/en/");
        //*Продукт на главной странице в блоке Campaigns*//
        //*Найти продукт*//
        WebElement product = driver.findElement(By.xpath("//div[@id='box-campaigns']//ul[@class='listing-wrapper products']/li[@class='product column shadow hover-light']/a[@class='link']"));
        //*Найти имя продукта*//
        WebElement main_name = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']"));
        String test_main_name =  main_name.getAttribute("textContent");
        //*Найти обычную цену продукта*//
        WebElement main_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        String test_main_price =  main_price.getAttribute("textContent");
        //*Найти цвет, зачеркнутость и размер обычной цены*//
        WebElement color_main_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        String test_color_main_price =  color_main_price.getCssValue("color");
        String test_style_main_price =  color_main_price.getCssValue("text-decoration");
        String test_size_main_price =  color_main_price.getCssValue("font-size");
        //*Найти акционную цену продукта*//
        WebElement sale_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        String test_sale_price =  sale_price.getAttribute("textContent");
        //*Найти цвет, толщину и размер акционной цены*//
        WebElement color_sale_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        String test_color_sale_price =  color_sale_price.getCssValue("color");
        String test_weight_sale_price =  color_sale_price.getCssValue("font-weight");
        String test_size_sale_price =  color_sale_price.getCssValue("font-size");

        product.click();

        //*Найти имя продукта в новом окне*//
        WebElement product_name = driver.findElement(By.xpath("//h1[@class='title']"));
        String test_product_name =  product_name.getAttribute("textContent");
        //*Найти обычную цену продукта в новом окне*//
        WebElement product_main_price = driver.findElement(By.xpath("//div[@class='information']//s[@class='regular-price']"));
        String test_product_main_price =  product_main_price.getAttribute("textContent");
        //*Найти цвет, зачеркнутость и размер обычной цены продукта в новом окне*//
        WebElement color_product_main_price = driver.findElement(By.xpath("//div[@class='information']//s[@class='regular-price']"));
        String test_color_product_main_price =  color_product_main_price.getCssValue("color");
        String test_style_product_main_price =  color_product_main_price.getCssValue("text-decoration");
        String test_size_product_main_price =  color_product_main_price.getCssValue("font-size");
        //*Найти акционную цену продукта в новом окне*//
        WebElement product_sale_price = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
        String test_product_sale_price =  product_sale_price.getAttribute("textContent");
        //*Найти цвет, толщину и размер акционной цены продукта в новом окне*//
        WebElement color_product_sale_price = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
        String test_color_product_sale_price =  color_product_sale_price.getCssValue("color");
        String test_weight_product_sale_price =  color_product_sale_price.getCssValue("font-weight");
        String test_size_product_sale_price =  color_product_sale_price.getCssValue("font-size");

        //*а) на главной странице и на странице товара сравнить, совпадает ли текст названия товара*//
            if (test_main_name.equals(test_product_name)){
                result= "совпадают";
            }
            else {
                result= "не совпадают";
            }
            System.out.println("Названия товаров " + result);
        //*б) на главной странице и на странице товара сравнить совпадают ли цены (обычная и акционная)*//
            if (test_main_price.equals(test_product_main_price)){
                result= "совпадают";
            }
            else {
                result= "не совпадают";
            }
            System.out.println("Обычные цены товаров " + result);

            if (test_sale_price.equals(test_product_sale_price)){
                result= "совпадают";
            }
            else {
                result= "не совпадают";
            }
            System.out.println("Акционные цены товаров " + result);
        //*в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)*//
            System.out.println("Цвет обычной цены на главной странице: " + test_color_main_price);
            System.out.println("Форматирование обычной цены на главной странице: " + test_style_main_price);
            System.out.println("Цвет обычной цены на новой странице: " + test_color_product_main_price);
            System.out.println("Форматирование обычной цены на главной странице: " + test_style_product_main_price);
        // *г) акционная жирная и красная*//
            System.out.println("Цвет акционной цены на главной странице: " + test_color_sale_price);
            System.out.println("Форматирование акционной цены на главной странице: " + test_weight_sale_price);
            System.out.println("Цвет акционной цены на новой странице: " + test_color_product_sale_price);
            System.out.println("Форматирование акционной цены на новой странице: " + test_weight_product_sale_price);
        //*д) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)*//
            if (test_size_main_price.compareTo(test_size_sale_price)>0){
                 result = "больше";
            }
            else {
                result = "меньше";
            }
            System.out.println("Акционная цена " + result + ", чем обычная цена на главной странице ");
            if (test_size_product_main_price.compareTo(test_size_product_sale_price)>0){
                result = "больше";
            }
            else {
                result = "меньше";
            }
            System.out.println("Акционная цена " + result + ", чем обычная цена на новой странице ");
    driver.quit();
    }
}
