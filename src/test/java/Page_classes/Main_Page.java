package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main_Page {
    public static WebDriver driver;

    public Main_Page(WebDriver driver){
        Main_Page.driver = driver;
    }

    public void go_to_account(){
        WebElement AccountBox = driver.findElement(By.xpath("//*[@title='View my customer account']"));
        AccountBox.click();
    }
    public void search(String item){
        WebElement search_box = driver.findElement(By.name("s"));
        search_box.sendKeys(item);
        search_box.submit();
    }
}
