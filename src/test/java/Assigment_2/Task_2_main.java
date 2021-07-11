package Assigment_2;

import Page_classes.Account_Page;
import Page_classes.Login_Page;
import Page_classes.Main_Page;
import Page_classes.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Task_2_main {
    public WebDriver driver;
//    preloading variables
    public String email = "niufkeuzxetqmbjazs@wqcefp.com";
    public String password = "kangurek1";
    public String current_price;
    public String current_order_id;
//    preloading page classes
    Main_Page mainPage;
    Item_List_Page itemListPage;
    Item_Page itemPage;
    Shopping_Cart_Page shoppingCartPage;
    Payment_Page paymentPage;
    Order_Confirmation_Page orderConfirmationPage;
    Account_Page accountPage;
    Order_History_Page orderHistoryPage;

    @Given("User is logged in to the shop")
    public void logging_in() throws InterruptedException {
//        driver configuration
        System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver");
//        initialising new browser window
        driver = new FirefoxDriver();
//        maximising window size
        driver.manage().window().maximize();
//        opening "log-in" site
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
//        logging in
        Login_Page loginPage = new Login_Page(driver);
        loginPage.login_shop(email, password);
//        initializing classes
        mainPage = new Main_Page(driver);
        itemListPage = new Item_List_Page(driver);
        itemPage = new Item_Page(driver);
        shoppingCartPage = new Shopping_Cart_Page(driver);
        paymentPage = new Payment_Page(driver);
        orderConfirmationPage = new Order_Confirmation_Page(driver);
        accountPage = new Account_Page(driver);
        orderHistoryPage = new Order_History_Page(driver);
//        initializing implicitlyWait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @And("User is on Presta shop homepage")
    public void getting_to_homepage(){
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @When("^User uses shop search engine to find \\\"([^\"]*)\"$")
    public void searching_for_item(String item){
        mainPage.search(item);
    }

    @And("^User checks if \"([^\"]*)\" is on discount$")
    public void discount(String item){
        itemListPage.discount_checker(item);
    }

    @And("^User clicks on the \"([^\"]*)\" box$")
    public void item_click(String item){
        itemListPage.item_click(item);
    }

    @And("^User chooses item size \"([^\"]*)\"$")
    public void item_size(String size){
        itemPage.choosing_size(size);
    }

    @And("^User chooses quantity of item \"([^\"]*)\"$")
    public void item_quantity(String quantity){
        itemPage.choosing_quantity(quantity);
    }

    @And("User is adding items to his shopping cart")
    public void adding_item(){
        itemPage.adding_to_cart();
    }

    @And("User opens checkout page")
    public void opening_checkout_page(){
        itemPage.checkout_click();
        shoppingCartPage.checkout_click();
    }
    @And("User chooses address")
    public void choosing_address(){
        paymentPage.accepting_address();
    }

    @And("User chooses PrestaShop \"pick up in store\" shipping method")
    public void choosing_shipping_method(){
        paymentPage.accepting_shipping_method();
    }

    @And("User chooses \"Pay by Check\" payment method")
    public void choosing_payment(){
        paymentPage.payment_pay_by_check();
    }

    @And("User checks \"terms of service\" box")
    public void accepting_terms_of_service(){
        paymentPage.terms_of_service_click();
    }

    @And("User clicks \"order with an obligation to pay\" button")
    public void complete_order(){
        paymentPage.order_completed_click();
    }

    @Then("User sees confirmation page")
    public void confirmation_page_check() throws IOException {
        orderConfirmationPage.confirmation_of_order();
//          initialising date formatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
//          making a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,
                    new File("screenshots/Order_Confirmation_Page_Screenshot_"+dtf.format(now)+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//          saving id and price of order for later usage
        WebElement price = driver.findElement(By.xpath("//*[@class='col-xs-5 text-xs-right bold']"));
        current_price = price.getText();
        WebElement order_id = driver.findElement(By.xpath("//*[contains(text(),'Order reference')]"));
        current_order_id = order_id.getText().substring(order_id.getText().length()-9);
    }
    @And("User goes to order history page")
    public void go_to_order_history(){
        mainPage.go_to_account();
        accountPage.go_to_history();
    }
    @And("User checks order history")
    public void order_history_check(){
        orderHistoryPage.id_and_price_check(current_order_id,current_price);
    }
}