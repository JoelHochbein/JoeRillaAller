package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS852Steps {

    WebDriver driver;
    String email = "maxmusterman@email.com";
    String password = "passwort";
    String emailinvalid = "maxmusterman456@email.com";
    String passwordinvalid = "passwort765";

    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/login");
    }
    @When("User enters a valid Email and Password")
    public void user_enters_a_valid_email_and_password() {
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
    }
    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")));
        System.out.println("User is logged in!");
    }
    @And("user should be automatically redirected to the homepage")
    public void user_should_be_automatically_redirected_to_the_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[1]/div[1]/strong")));
        System.out.println("User is successfully redirected to the homepage!");
        driver.close();
    }
    @Given("User is on the Login Page1")
    public void user_is_on_the_login_page1() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/login");
    }
    @When("User enters a invalid Email and Password")
    public void user_enters_a_invalid_email_and_password() {
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(emailinvalid);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(passwordinvalid);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
    }
    @Then("The Site demands the user to enter valid login data")
    public void the_site_demands_the_user_to_enter_valid_login_data() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")));
        System.out.println("Site demands the user to enter valid login data!");
    }
    @And("User shouldnt be able to login")
    public void user_shouldnt_be_able_to_login() {
        System.out.println("User isnt able to login!");
        driver.close();
    }
}
