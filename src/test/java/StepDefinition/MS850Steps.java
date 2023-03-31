package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class MS850Steps {
    WebDriver driver;
    @Given("user is on page and is logged in")
    public void user_is_on_page_and_is_logged_in() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.className("email")).sendKeys("maxmusterman@email.com");
        driver.findElement(By.className("password")).sendKeys("passwort");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
    }
    @When("user clicks on orderhistory")
    public void user_clicks_on_orderhistory() {
        driver.get("https://demowebshop.tricentis.com/customer/orders");

    }
    @Then("website shows a list of the previous orders")
    public void website_shows_a_list_of_the_previous_orders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[1]/h1")));
        System.out.println("list of previous orders is shown!");
    }
    @Then("every order contains informations")
    public void every_order_contains_informations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/ul/li[1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/ul/li[2]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/ul/li[3]")));
        System.out.println("every order contains the expected informations!");
        driver.close();
    }

}
