package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class New_Adress_Page {
    public static WebDriver driver;

    public New_Adress_Page(WebDriver driver){
        New_Adress_Page.driver = driver;
    }
    public void alias_setup(String type_alias){
        WebElement alias_box = driver.findElement(By.name("alias"));
        alias_box.sendKeys(type_alias);
    }
    public void address_setup(String type_address){
        WebElement address_box = driver.findElement((By.name("address1")));
        address_box.sendKeys(type_address);
    }
    public void city_setup(String type_city){
        WebElement city_box = driver.findElement(By.name("city"));
        city_box.sendKeys(type_city);
    }
    public void postalcode_setup(String type_postalcode){
        WebElement postalcode_box = driver.findElement(By.name("postcode"));
        postalcode_box.sendKeys(type_postalcode);
    }
    public void submit(){
        WebElement submit_button = driver.findElement(By.xpath("//*[@class='btn btn-primary float-xs-right']"));
        submit_button.click();
    }
}
