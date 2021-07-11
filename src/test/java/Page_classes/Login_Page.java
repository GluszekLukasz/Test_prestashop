package Page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
    public static WebDriver driver;

    public Login_Page(WebDriver driver)
    {
        Login_Page.driver = driver;
    }

    public void login_shop(String email, String password){
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }
}
