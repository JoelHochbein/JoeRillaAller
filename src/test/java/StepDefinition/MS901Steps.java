package StepDefinition;
import Pages.TDWHomePage;
import Pages.TDW_login;
import Pages.TDW_register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MS901Steps {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/";
    String firstname = "max";
    String lastname = "musterman";
    Random ran = new Random();
    int x = ran.nextInt(1000) +1;
    String mail = "maxmusterman" + x +"@mail.com";
    String password ="passwort";
    @Given("User is on Homepage.")
    public void user_is_on_homepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get(url);
    }
    @When("User clicks on Register")
    public void user_clicks_on_register() {
        TDWHomePage.register(driver).click();
    }
    @And("User enters his Data")
    public void user_enters_his_data() {
        TDW_register.male(driver).click();
        TDW_register.firstname(driver).sendKeys(firstname);
        TDW_register.lastname(driver).sendKeys(lastname);
        TDW_register.email(driver).sendKeys(mail);
        TDW_register.password(driver).sendKeys(password);
        TDW_register.confirmpassword(driver).sendKeys(password);
    }
    @And("Clicks on Register")
    public void clicks_on_register() {
        TDW_register.registerbtn(driver).click();
        TDW_register.registercontinue(driver).click();
    }
    @Then("User is registered and logged in")
    public void user_is_registered_and_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDWHomePage.log_in_proof(driver)));
    }
    @And("Automatically redirected to Homepage.")
    public void automatically_redirected_to_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDWHomePage.TDWpng(driver)));
        System.out.println("User is successfully registered, logged in and redirected to the Homepage!");
        driver.close();
    }
}
