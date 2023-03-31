package StepDefinition;

import Pages.TDWHomePage;
import Pages.TDW_register;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Pages.DQALogin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS998Steps {
    WebDriver driver;
    String username = "maxmusterman";
    String passwort = "Passwort123!";
    Faker faker = new Faker();
    @Given("user is on website!!")
    public void puser_is_on_website() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/login");
    }
    @When("he enters his valid data")
    public void phe_enters_his_valid_data() {
        DQALogin.username(driver).sendKeys(username);
        DQALogin.passwort(driver).sendKeys(passwort);
    }
    @When("clicks on Log In!")
    public void pclicks_on_log_in() {
        DQALogin.login(driver).click();
    }
    @Then("user should be logged in.")
    public void puser_should_be_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(DQALogin.validproof(driver)));
        driver.close();
    }


    @Given("user is on website..")
    public void nuser_is_on_website() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/login");
    }
    @When("he enters his invalid data")
    public void nhe_enters_his_invalid_data() {
        DQALogin.username(driver).sendKeys(faker.name().firstName());
        DQALogin.passwort(driver).sendKeys("Passwort321!");
    }
    @When("clicks on Log In.")
    public void nclicks_on_log_in() {
        DQALogin.login(driver).click();
    }
    @Then("user shouldnt be able to login")
    public void nuser_shouldnt_be_able_to_login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(DQALogin.invalidproof(driver)));
    }
    //INVALID


}
