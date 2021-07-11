package Page_classes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Order_Confirmation_Page {
    public static WebDriver driver;

    public Order_Confirmation_Page(WebDriver driver){
        Order_Confirmation_Page.driver = driver;
    }
    public void confirmation_of_order(){
        WebElement confirmation_text = driver.findElement(By.id("content-hook_order_confirmation"));
        Assert.assertTrue(confirmation_text.getText().contains("YOUR ORDER IS CONFIRMED"));
        System.out.println("Order is complete");
    }
}
