package StepDefinition;

import Pages.DQApractiseform;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS920Steps {
    WebDriver driver;
    Faker faker = new Faker();
    @Given("user is on website")
    public void user_is_on_website() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/alerts");
    }
    @When("he clicks on click me")
    public void he_clicks_on_click_me() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebDriverWait wait5secs = new WebDriverWait(driver, Duration.ofSeconds(5));

        DQApractiseform.clickme1(driver).click();
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        DQApractiseform.clickme2(driver).click();
        Alert alert2 = wait5secs.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        DQApractiseform.clickme3(driver).click();
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        DQApractiseform.clickme4(driver).click();
        Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(faker.name().firstName() + " " + faker.name().lastName());
        driver.switchTo().alert().accept();

    }
    @Then("a alert pops up")
    public void a_alert_pops_up() {
        System.out.println("Every Alert popped up!");
        driver.close();
    }
}
