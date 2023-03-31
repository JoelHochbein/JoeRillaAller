package StepDefinition;

import Pages.TDWHomePage;
import Pages.TDW_login;
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

public class MS907Steps {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/";
    String mail = "maxmusterman@email.com";
    String pwd = "passwort";

    @Given("user opens the website.")
    public void user_opens_the_website() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get(url);
    }
    @And("User is logged in.")
    public void user_is_logged_in() {
        TDWHomePage.log_in(driver).click();
        TDW_login.email_textbox(driver).sendKeys(mail);
        TDW_login.password_textbox(driver).sendKeys(pwd);
        TDW_login.log_in_button(driver).click();
        driver.get(url);


    }
    @When("user searches for a jewelery of his choice")
    public void user_searches_for_a_jewelery_of_his_choice() {
        TDWHomePage.textbox_search(driver).sendKeys("Jewelry");
        TDWHomePage.button_search(driver).click();

    }
    @And("Adds it to the Shopping cart")
    public void adds_it_to_the_shopping_cart() {
        TDWHomePage.jewelry(driver).click();
        TDWHomePage.lengthincm(driver).sendKeys("120");
        TDWHomePage.addtocartbutton(driver).click();

    }
    @And("Clicks on Shopping cart")
    public void clicks_on_shopping_cart() {
        TDWHomePage.shoppingcart(driver).click();
    }
    @Then("Jewelery should show up in Shopping cart")
    public void jewelery_should_show_up_in_shopping_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDWHomePage.shoppingcartproof(driver)));
        System.out.println("Test successful!");
    }
}
