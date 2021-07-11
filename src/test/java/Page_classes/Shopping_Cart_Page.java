package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shopping_Cart_Page {
    public static WebDriver driver;

    public Shopping_Cart_Page(WebDriver driver){
        Shopping_Cart_Page.driver = driver;
    }
    public void checkout_click(){
        WebElement checkout_button = driver.findElement(By.xpath("//*[text()='Proceed to checkout']"));
        checkout_button.click();
    }
}
