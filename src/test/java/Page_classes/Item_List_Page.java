package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Item_List_Page {
    public static WebDriver driver;

    public Item_List_Page(WebDriver driver){
        Item_List_Page.driver = driver;
    }
    public void discount_checker(String discounted_item) {
        List<WebElement> discount = driver.findElements(By.xpath("//div[@class='product-description']"));
        for (int x = 0; x < discount.size(); x++) {
            if (discount.get(x).getText().contains(discounted_item)) {
                if (discount.get(x).getText().contains("Regular price")) {
                    System.out.println(discounted_item + " is on discount");
                } else {
                    System.out.println(discounted_item + "is not on discount");
                }

            }
        }
    }
    public void item_click(String item){
        WebElement product = driver.findElement(By.xpath("//*[text()='"+item+ "']"));
        product.click();

    }
}

