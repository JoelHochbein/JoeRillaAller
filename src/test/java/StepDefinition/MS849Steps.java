package StepDefinition;

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

public class MS849Steps {
    WebDriver driver;
    @Given("Browser is opened")
    public void browser_is_opened() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }
    @When("user open the TDW Site")
    public void user_open_the_tdw_site() {

        driver.get("https://demowebshop.tricentis.com/");
    }
    @Then("website loads in less then {int} seconds")
    public void website_loads_in_less_then_seconds(Integer int1) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newsletter-subscribe-button\"]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[2]/div[2]/ul/li/a")));
        System.out.println("the Website sucessfully loaded in less then 3 seconds!");
        driver.close();
    }
}
