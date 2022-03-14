package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver){
        super(driver);
    }
    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add_cart_product"))).click();
    }
}
