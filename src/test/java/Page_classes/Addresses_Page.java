package Page_classes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Addresses_Page {
    public static WebDriver driver;

    public Addresses_Page(WebDriver driver){
        Addresses_Page.driver = driver;
    }

    public void go_to_crate_new_address(){
        WebElement create_new_address_box = driver.findElement(By.xpath("//*[text()='Create new address']"));
        create_new_address_box.click();
    }
    public void New_address_created(){
        WebElement successfully_created = driver.findElement(By.id("notifications"));
        Assert.assertEquals("Address successfully added!", successfully_created.getText());
    }
    public void checking_address_informations(String alias, String address, String city, String postalcode){
        List<WebElement> address_box = driver.findElements(By.xpath("//div[@class='address-body']"));
        Assert.assertTrue("Alias isn't the same", address_box.get(address_box.size()-1).getText().contains(alias));
        Assert.assertTrue("Address isn't the same", address_box.get(address_box.size()-1).getText().contains(address));
        Assert.assertTrue("City isn't the same", address_box.get(address_box.size()-1).getText().contains(city));
        Assert.assertTrue("Postal code isn't the same", address_box.get(address_box.size()-1).getText().contains(postalcode));
    }
    public void delete_new_address(){
        List<WebElement> delete_buttons = driver.findElements(By.xpath("//*[text()='Delete']"));
        int list_size = delete_buttons.size();
        delete_buttons.get(delete_buttons.size() - 1).click();
        delete_buttons = driver.findElements(By.xpath("//*[text()='Delete']"));
        Assert.assertNotEquals("address wasn't deleted",list_size, delete_buttons.size());
        System.out.println("Address was deleted");
    }
}
