package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MS944Steps {
    WebDriver driver;

    @Given("user opened his browser")
    public void user_opened_his_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-notifications");
        options.addArguments("window-size=1280,720");
        driver = new ChromeDriver(options);

    }
    @When("user opens the website!")
    public void user_opens_the_website() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.focus.de/");
        Thread.sleep(2000);
        WebElement framecookies = driver.findElement(By.id("sp_message_iframe_777530"));
        driver.switchTo().frame(framecookies);

    }
    @When("accepts the cookies")
    public void accepts_the_cookies() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[title='Akzeptieren']")).click();
    }
    @Then("website should be available")
    public void website_should_be_available() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-navigation-v3\"]/div[1]/div/div[1]/div[1]/form/input")));
        driver.close();
    }
}
