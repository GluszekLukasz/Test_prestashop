package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Item_Page {
    public static WebDriver driver;

    public Item_Page(WebDriver driver){
        Item_Page.driver = driver;
    }
    public void choosing_size(String size){
        WebElement size_box = driver.findElement(By.xpath("//option[@title='"+size+"']"));
        size_box.click();
    }
    public void choosing_quantity(String quantity){
        WebElement quantity_box = driver.findElement(By.id("quantity_wanted"));
        quantity_box.clear();
        quantity_box.sendKeys(quantity);
    }
    public void adding_to_cart(){
        WebElement add_to_cart_button = driver.findElement(By.xpath("//*[@data-button-action='add-to-cart']"));
        add_to_cart_button.click();
    }
    public void checkout_click(){
        WebElement checkout_button = driver.findElement(By.xpath("//*[text()='Proceed to checkout']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(checkout_button));
        checkout_button.click();
    }
}
