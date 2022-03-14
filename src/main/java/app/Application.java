package app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CheckoutPage;
import page.MainPage;
import page.ProductPage;
import page.ShopCart;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static WebDriver driver;
    public MainPage mainPage;
    public ProductPage productPage;
    public CheckoutPage checkoutPage;
    public ShopCart shopcart;

    public Application(){
        System.setProperty("webdriver.chrome.driver", "C:\\project\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        shopcart = new ShopCart (driver);
    }

    public static List<String> getAllProducts (List <WebElement> productsList) {
        List <String> products_array = new ArrayList<String>();
        for (WebElement pr : productsList){
            products_array.add(pr.getText().toString());
        }
        return products_array;
    }

    public void quit() {
        driver.quit();
    }
}
