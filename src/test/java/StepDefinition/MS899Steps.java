package StepDefinition;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pages.TDW_login;
import Pages.TDWHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS899Steps {
    WebDriver driver;
    String mail = "maxmusterman@email.com";
    String password = "passwort";
    String URL = "https://demowebshop.tricentis.com/login";
    @Given("User is on Homepage")
    public void user_is_on_homepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get(URL);
    }
    @When("User clicks on Login")
    public void user_clicks_on_login() {
        TDWHomePage.log_in(driver).click();
    }
    @And("User enters Email and Password")
    public void user_enters_email_and_password() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDW_login.email_textbox(driver)));

        TDW_login.email_textbox(driver).sendKeys(mail);
        TDW_login.password_textbox(driver).sendKeys(password);
        TDW_login.log_in_button(driver).click();
    }
    @Then("User is logged in")
    public void user_is_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDWHomePage.log_in_proof(driver)));

        WebElement element = TDWHomePage.log_in_proof(driver);
        String text = element.getText();

        if (text.equals(mail)) {
            System.out.println("User ist erfolgreich eingeloggt!");
        }
        else {
            System.out.println("User ist nicht erfolgreich eingeloggt!");
        }
        System.out.println(text);
    }
    @And("Automatically redirected to Homepage")
    public void automatically_redirected_to_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDWHomePage.TDWpng(driver)));
        driver.close();
    }
}
