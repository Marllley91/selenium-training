package app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CheckoutPage;
import page.MainPage;
import page.ProductPage;
import page.ShopCart;

public class Application {
    public WebDriver driver;

    public MainPage mainPage;
    public ProductPage productPage;
    public CheckoutPage checkoutPage;
    public ShopCart shopcart;

    public Application(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        shopcart = new ShopCart (driver);
    }

    public void quit() {
        driver.quit();
    }
}
