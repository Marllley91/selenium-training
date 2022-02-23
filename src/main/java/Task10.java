import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Task10 {
    public static void main(String[] args) throws ParseException {
        System.setProperty("webdriver.chrome.driver", "C:\\project\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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
            String test_main_name = main_name.getAttribute("textContent");
            //*Найти обычную цену продукта*//
            WebElement main_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
            String test_main_price = main_price.getAttribute("textContent");
            //*Найти цвет обычной цены*//
                WebElement color_main_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
                String test_color_main_price = color_main_price.getCssValue("color");
                String[] rgba = test_color_main_price.replace("rgba(", "").replace(")", "").split(", ");
                int r = Integer.parseInt(rgba[0]);
                int g = Integer.parseInt(rgba[1]);
                int b = Integer.parseInt(rgba[2]);
                int a = Integer.parseInt(rgba[3]);
            //*Найти зачеркнутость обычной цены*//
            String test_style_main_price = color_main_price.getCssValue("text-decoration-style");
            //*Найти размер обычной цены*//
            String test_size_main_price = color_main_price.getCssValue("font-size");
            String font_size_main = test_size_main_price.replaceAll("px", " ");
            double db_test_size_main_price = Double.valueOf(font_size_main);
            //*Найти акционную цену продукта*//
            WebElement sale_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
            String test_sale_price = sale_price.getAttribute("textContent");
            //*Найти цвет акционной цены*//
            WebElement color_sale_price = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
            String test_color_sale_price = color_sale_price.getCssValue("color");
            String[] rgba1 = test_color_sale_price.replace("rgba(", "").replace(")", "").split(", ");
            int g1 = Integer.parseInt(rgba1[1]);
            int b1 = Integer.parseInt(rgba1[2]);
            //*Найти толщину акционной цены*//
            String test_weight_sale_price = color_sale_price.getCssValue("font-weight");
            //*Найти размер акционной цены*//
            String test_size_sale_price = color_sale_price.getCssValue("font-size");
            String font_size_sale = test_size_sale_price.replaceAll("px", " ");
            double db_test_size_sale_price = Double.valueOf(font_size_sale);

            product.click();

            //*Найти имя продукта в новом окне*//
            WebElement product_name = driver.findElement(By.xpath("//h1[@class='title']"));
            String test_product_name = product_name.getAttribute("textContent");
            //*Найти обычную цену продукта в новом окне*//
            WebElement product_main_price = driver.findElement(By.xpath("//div[@class='information']//s[@class='regular-price']"));
            String test_product_main_price = product_main_price.getAttribute("textContent");
            //*Найти цвет в новом окне*//
            WebElement color_product_main_price = driver.findElement(By.xpath("//div[@class='information']//s[@class='regular-price']"));
            String test_color_product_main_price = color_product_main_price.getCssValue("color");
            String[] rgba2 = test_color_product_main_price.replace("rgba(", "").replace(")", "").split(", ");
            int r2 = Integer.parseInt(rgba2[0]);
            int g2 = Integer.parseInt(rgba2[1]);
            int b2 = Integer.parseInt(rgba2[2]);
            int a2 = Integer.parseInt(rgba2[3]);
            //*Найти зачеркнутость обычной цены продукта в новом окне*//
            String test_style_product_main_price = color_product_main_price.getCssValue("text-decoration-style");
            //*Найти размер обычной цены продукта в новом окне*//
            String test_size_product_main_price = color_product_main_price.getCssValue("font-size");
            String font_main_product_size = test_size_sale_price.replaceAll("px", " ");
            double db_test_size_product_main_price = Double.valueOf(font_main_product_size);
            //*Найти акционную цену продукта в новом окне*//
            WebElement product_sale_price = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
            String test_product_sale_price = product_sale_price.getAttribute("textContent");
            //*Найти цвет акционной цены продукта в новом окне*//
            WebElement color_product_sale_price = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
            String test_color_product_sale_price = color_product_sale_price.getCssValue("color");
            String[] rgba3 = test_color_product_sale_price.replace("rgba(", "").replace(")", "").split(", ");
            int g3 = Integer.parseInt(rgba3[1]);
            int b3 = Integer.parseInt(rgba3[2]);
            //*Найти толщину акционной цены продукта в новом окне*//
            String test_weight_product_sale_price = color_product_sale_price.getCssValue("font-weight");
            //*Найти размер акционной цены продукта в новом окне*//
            String test_size_product_sale_price = color_product_sale_price.getCssValue("font-size");
            String font_size_sale_product = test_size_product_sale_price.replaceAll("px", " ");
            double db_test_size_sale_product_price = Double.valueOf(font_size_sale_product);
            //*а) на главной странице и на странице товара сравнить, совпадает ли текст названия товара*//
            if (test_main_name.equals(test_product_name)) {
                result = "совпадают";
            } else {
                result = "не совпадают";
            }
            System.out.println("Названия товаров " + result);
            //*б) на главной странице и на странице товара сравнить совпадают ли цены (обычная и акционная)*//
            if (test_main_price.equals(test_product_main_price)) {
                result = "совпадают";
            } else {
                result = "не совпадают";
            }
            System.out.println("Обычные цены товаров " + result);

            if (test_sale_price.equals(test_product_sale_price)) {
                result = "совпадают";
            } else {
                result = "не совпадают";
            }
            System.out.println("Акционные цены товаров " + result);
            //*в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)*//
            if (r == g) {
                if (g == b) {
                    result = "серый";
                }
            } else {
                result = "не серый";
            }
            System.out.println("Цвет обычной цены на главной странице: " + result);

            if (test_style_main_price.equals("solid")) {
                result = "зачеркнутый";
            } else {
                result = "не зачеркнутый";
            }
            System.out.println("Шрифт обычной цены на главной странице: " + result);

            if (r2 == g2) {
                if (g2 == b2) {
                    result = "серый";
                }
            } else {
                result = "не серый";
            }
            System.out.println("Цвет обычной цены на новой странице: " + result);

            if (test_style_main_price.equals("solid")) {
                result = "зачеркнутый";
            } else {
                result = "не зачеркнутый";
            }
            System.out.println("Шрифт обычной цены на новой странице: " + result);
            // *г) акционная жирная и красная*//
            if (g1 == 0) {
                if (b1 == 0) {
                    result = "красный";
                }
            } else {
                result = "не красный";
            }

            System.out.println("Цвет акционной цены на главной странице: " + result);

            if (Integer.parseInt(test_weight_sale_price) >= 700) {
                result = "жирный";
            } else {
                result = "не жирный";
            }
            System.out.println("Шрифт акционной цены на главной странице: " + result);

            if (g3 == 0) {
                if (b3 == 0) {
                    result = "красный";
                }
            } else {
                result = "не красный";
            }

            System.out.println("Цвет акционной цены на главной странице: " + result);

            if (Integer.parseInt(test_weight_sale_price) >= 700) {
                result = "жирный";
            } else {
                result = "не жирный";
            }
            System.out.println("Шрифт акционной цены на новой странице: " + result);
            //*д) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)*//
            if (db_test_size_sale_price > db_test_size_main_price) {
                result = "больше";
            } else {
                result = "меньше";
            }
            System.out.println("Акционная цена " + result + ", чем обычная цена на главной странице ");

            if (db_test_size_sale_product_price > db_test_size_product_main_price) {
                result = "больше";
            } else {
                result = "меньше";
            }
            System.out.println("Акционная цена " + result + ", чем обычная цена на новой странице ");
            driver.quit();
        }
    }

