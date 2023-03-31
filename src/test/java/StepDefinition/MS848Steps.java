package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MS848Steps {
    WebDriver driver;

    @Given("Website is live and available")
    public void website_is_live_and_available() {
        System.out.println("Website is live and available!");
    }

    @When("Website works on Firefox")
    public void website_works_on_firefox() {
        driver = new FirefoxDriver();
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Website works on Firefox!");
        driver.close();
    }

    @And("Website works on Chrome")
    public void website_works_on_chrome() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Website works on Chrome!");
        driver.close();
    }

    @And("Website works on Edge")
    public void website_works_on_edge() {
        driver = new EdgeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Website works on Edge!");
        driver.close();
    }

    @Then("Website works on every browser")
    public void website_works_on_every_browser() {
        System.out.println("Website works on every Browsers!");
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

