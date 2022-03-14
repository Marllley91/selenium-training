package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver){
        super(driver);
    }
    public void addProductToCart() {
        try {
            new Select(driver.findElement(By.name("options[Size]"))).selectByValue("Small");
        }
        catch (Exception ex) {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add_cart_product"))).click();
    }
}
