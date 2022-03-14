package tests;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Task19 extends TestBase{
    List<String> productsList = new ArrayList<String>();

    @Test
    public void AddProductsToCart() {
        app.mainPage.open();
        app.mainPage.addProductsToCart(productsList);
        app.checkoutPage.CheckOut();
        app.checkoutPage.deleteFromCart();
        Assert.assertTrue(app.checkoutPage.isCartEmpty());
    }
}
