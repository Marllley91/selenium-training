package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void CheckOut () {
        driver.findElement(By.linkText("Checkout »")).click();
    }
    public void deleteFromCart(){
        WebElement deleteButton;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='remove_cart_item']")));
        while(driver.findElements(By.xpath("//button[@name='remove_cart_item']")).size() != 0){
            deleteButton = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
            deleteButton.click();
            wait.until(ExpectedConditions.stalenessOf(deleteButton));
        }
    }
    public boolean isCartEmpty(){
        return driver.findElement(By.tagName("p")).getText().contains("There are no items in your cart.");
    }
}
