package Page_classes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Order_History_Page {
    public static WebDriver driver;

    public Order_History_Page(WebDriver driver){
        Order_History_Page.driver=driver;
    }
    public void id_and_price_check(String id, String price){
        WebElement history_id= driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr/th[1]"));
        WebElement history_price = driver.findElement((By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr/td[2]")));
        Assert.assertEquals("id doesn't match",id, history_id.getText());
        Assert.assertEquals("price doesn't match",price, history_price.getText());
    }
}
