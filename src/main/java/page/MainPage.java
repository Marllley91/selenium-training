package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class MainPage extends PageBase{
    public MainPage (WebDriver driver){
        super (driver);
    }
    public void open() {
        driver.get("http://localhost/litecart/en");
    }
    public void chooseProduct(String s) {
        driver.findElement(By.xpath("By.xpath(\"//div[@id='box-most-popular']//li/a[1]\")")).click();
    }
    public void addProductsToCart (List<String> productsList){
        for(int i = 0; i < 3; i++) {
            chooseProduct(productsList.get(i));
            new ProductPage(driver).addProductToCart();
            new ShopCart(driver).isProductAdded(i + 1);
            driver.navigate().back();
        }
    }
}
