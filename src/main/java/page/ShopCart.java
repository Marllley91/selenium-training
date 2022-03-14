package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ShopCart extends PageBlock{
    private int itemsCount;
    public ShopCart (WebDriver driver) {
        super(driver);
    }
    public int Count() {
        return Integer.valueOf(driver.findElement(By.xpath("//div[@id='cart']//a[@class='content']/span[@class='quantity']")).getText());
    }
    public void isProductAdded (int countAfter){
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver){
                if (Count() == countAfter)
                    return true;
                return null;
            }
        });
    }
}