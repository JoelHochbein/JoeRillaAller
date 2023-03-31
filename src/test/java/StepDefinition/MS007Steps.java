package StepDefinition;

import Pages.DQALinks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MS007Steps {
    WebDriver driver;

    @Given("user is on website dqalinks")
    public void user_is_on_website_dqalinks() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/links");
    }
    @When("he selects random link")
    public void he_selects_random_link() {
        Random random = new Random();
        int x = random.nextInt(7)+1;
        if (x == 1) {
            DQALinks.created(driver).click();
        }
        else if (x == 2) {
            DQALinks.nocontent(driver).click();
        }
        else if (x == 3) {
            DQALinks.moved(driver).click();
        }
        else if (x == 4) {
            DQALinks.badrequest(driver).click();
        }
        else if (x == 5) {
            DQALinks.unauthorized(driver).click();
        }
        else if (x == 6) {
            DQALinks.forbidden(driver).click();
        }
        else if (x == 7) {
            DQALinks.notfound(driver).click();
        }
    }
    @And("clickt it")
    public void clickt_it() {

    }
    @Then("he receives a status code and text")
    public void he_receives_a_status_code_and_text() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"linkResponse\"]")));

        WebElement linkResponseElement = driver.findElement(By.xpath("//*[@id=\"linkResponse\"]"));

        String linkResponseText = linkResponseElement.getText();

        String statusCode = linkResponseText.replaceAll(".*status <b>(\\d+)</b>.*", "$1");

        System.out.println(statusCode);
    }
}
