package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Account_Page {
    public static WebDriver driver;

    public Account_Page(WebDriver driver){
        Account_Page.driver = driver;
    }

    public void go_to_address(){
        WebElement Address_button = driver.findElement(By.id("addresses-link"));
        Address_button.click();
    }
    public void go_to_history(){
        WebElement history_button = driver.findElement(By.id("history-link"));
        history_button.click();
    }
}
