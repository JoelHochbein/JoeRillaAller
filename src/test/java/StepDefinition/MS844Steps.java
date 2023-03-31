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
import java.util.Random;
public class MS844Steps {
    WebDriver driver;
    @Given("user opens the website")
    public void user_opens_the_website() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
    }
    @When("user clicks on register")
    public void user_clicks_on_register() {
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
    }
    @And("fills the registration form w random generated data")
    public void fills_the_registration_form_w_random_generated_data() {
        Random rand = new Random();
        int n = rand.nextInt(999999);
        String mail = "musterman" + n + "@mail.com";
        String password = "password";

        driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Max");
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Musterman");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(password);

    }
    @And("clicks on register")
    public void clicks_on_register() {
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
    }
    @Then("User gets the message {string}")
    public void user_gets_the_message(String string) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")));
        System.out.println("Registration successful!");
        driver.close();
    }
}
