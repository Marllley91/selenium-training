package tests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static app.Application.driver;

public class Task19 extends TestBase{

    @Test
    public void AddProductsToCart() {
        app.mainPage.open();
        List <WebElement> productsList = driver.findElements(By.xpath("//div[@id='box-most-popular']//li/a[1]"));
        List<String> products_array = app.getAllProducts(productsList);
        app.mainPage.addProductToCart (products_array);
        app.checkoutPage.CheckOut();
        app.checkoutPage.deleteFromCart();
        Assert.assertTrue(app.checkoutPage.isCartEmpty());
    }


}
