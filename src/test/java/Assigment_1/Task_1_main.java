package Assigment_1;

import Page_classes.Account_Page;
import Page_classes.Addresses_Page;
import Page_classes.Login_Page;
import Page_classes.New_Adress_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task_1_main {
//      preloading variables
    public WebDriver driver;
    public String email = "niufkeuzxetqmbjazs@wqcefp.com";
    public String password = "kangurek1";
    public String current_alias;
    public String current_address;
    public String current_city;
    public String current_postalCode;
//      preloading page classes
    Addresses_Page addressesPage;
    Account_Page accountPage;
    New_Adress_Page newAddressesPage;



    @Given("User is logged in to Presta shop")
    public void logging_in() {

//        driver configuration
        System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver");

//        initializing new browser window
        driver = new FirefoxDriver();

//        maximising window size
        driver.manage().window().maximize();

//        opening "log-in" site
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

//        logging in
        Login_Page loginPage = new Login_Page(driver);
        loginPage.login_shop(email, password);

//        initializing classes
        addressesPage = new Addresses_Page(driver);
        accountPage = new Account_Page(driver);
        newAddressesPage = new New_Adress_Page(driver);

    }
    @When("User goes to NewAddressesPage")
    public void NewAddressesPage(){
//        Opening "Addresses" window
        accountPage.go_to_address();
//        Opening "new address" window
        addressesPage.go_to_crate_new_address();
    }
    @And("User adds a new Alias {string}")
    public void New_alias(String alias){
        newAddressesPage.alias_setup(alias);
//        setting up alias variable for future reference
        current_alias = alias;
    }
    @And("User adds a new Address {string}")
    public void New_address(String address) {
        newAddressesPage.address_setup(address);
//        setting up address variable for future reference
        current_address = address;
    }
    @And("User adds name of the city {string}")
    public void New_City(String city) {
        newAddressesPage.city_setup(city);
//        setting up city variable for future reference
        current_city = city;
    }
    @And("User adds new Postal Code {string}")
    public void New_PostalCode(String postalcode) {
//        setting up postalcode variable for future reference
        newAddressesPage.postalcode_setup(postalcode);
        current_postalCode = postalcode;
    }
    @And("User saves information")
    public void Address_info_submit() {
        newAddressesPage.submit();
    }

    @Then("User checks the new address")
    public void New_address_confirmation(){
        addressesPage.New_address_created();
//        checking if data on new address is correct
        addressesPage.checking_address_informations(current_alias, current_address, current_city, current_postalCode);
    }
    @And("User deletes new address")
    public void address_deletion(){
        addressesPage.delete_new_address();
    }
}
