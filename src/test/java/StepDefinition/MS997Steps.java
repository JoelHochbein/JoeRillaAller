package StepDefinition;

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

public class MS997Steps {
    WebDriver driver;
    @Given("user opens chipde")
    public void user_opens_chipde() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-notifications");
        options.addArguments("window-size=1280,720");
        driver = new ChromeDriver(options);

    }
    @When("accepts the cookies.")
    public void accepts_the_cookies() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.chip.de/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_message_iframe_732150")));
        WebElement framecookies = driver.findElement(By.id("sp_message_iframe_732150"));
        driver.switchTo().frame(framecookies);
    }
    @Then("cookie windows should disappear")
    public void cookie_windows_should_disappear() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Alle Akzeptieren']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"head-navigation\"]/ul/li[2]/a")));
        driver.close();
        System.out.println("erfolgreich!");
    }
}
