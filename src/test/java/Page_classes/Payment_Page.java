package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Payment_Page {
    public static WebDriver driver;

    public Payment_Page(WebDriver driver){
        Payment_Page.driver = driver;
    }

    public void accepting_address(){
        WebElement continue_button = driver.findElement(By.name("confirm-addresses"));
        continue_button.click();
    }
    public void accepting_shipping_method(){
        WebElement continue_button = driver.findElement(By.name("confirmDeliveryOption"));
        continue_button.click();
    }
    public void payment_pay_by_check(){
        WebElement pay_by_check_button = driver.findElement(By.id("payment-option-1"));
        pay_by_check_button.click();
    }
    public void terms_of_service_click(){
        WebElement terms_of_service = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        terms_of_service.click();
    }
    public void order_completed_click(){
        WebElement order_button = driver.findElement(By.xpath("//button[@class='btn btn-primary center-block']"));
        order_button.click();
    }

}
