package StepDefinition;

import Pages.TDWHomePage;
import Pages.TDW_register;
import com.github.javafaker.Faker;
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

public class MS918Steps {
    WebDriver driver;
    Faker faker = new Faker();

    String password = faker.name().fullName() + faker.number().digits(4);
    @Given("Testdata is ready")
    public void testdata_is_ready() {
        System.out.println("Testdata is ready!");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

    }
    @When("I register w Data from the Testdata Generator")
    public void i_register_w_data_from_the_testdata_generator() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/register");

        Random ran = new Random();
        int x = ran.nextInt(2) + 1;
        if (x == 1) {
            TDW_register.male(driver).click();
        }
        else if (x == 2) {
            TDW_register.female(driver).click();
        }

        TDW_register.firstname(driver).sendKeys(faker.name().firstName());
        TDW_register.lastname(driver).sendKeys(faker.name().lastName());
        TDW_register.email(driver).sendKeys(faker.name().firstName() + faker.name().lastName() + faker.number().digits(4) + "@mail.com");
        TDW_register.password(driver).sendKeys(password);
        TDW_register.confirmpassword(driver).sendKeys(password);
        Thread.sleep(2000);
        TDW_register.registerbtn(driver).click();
    }
    @Then("The registration should be successful")
    public void the_registration_should_be_successful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDW_register.registerproof(driver)));
        driver.close();
        System.out.println("Registration completed!");
    }
}
