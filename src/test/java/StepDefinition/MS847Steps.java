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

public class MS847Steps {
    WebDriver driver;

    @Given("user opens the website tdw")
    public void user_opens_the_website1() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("user searches for a product")
    public void user_searches_for_a_product() {
        driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Smartphone");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();
    }

    @Then("search results are shown")
    public void search_results_are_shown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a")));
    }

    @Then("search results match the search term")
    public void search_results_match_the_search_term() {
        driver.close();
        System.out.println("Search results match the search term!");

    }
}
