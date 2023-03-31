package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS897Steps {
    WebDriver driver;

    @Given("user opens the site")
    public void user_opens_the_site() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
    }
    @When("user chooses {int} products from the same group")
    public void user_chooses_products_from_the_same_group(Integer int1) {
        System.out.println("Chosen Products: 1MP 60GB Hard Drive Handycam Camcorder;Camcorder;Digital SLR Camera 12.2 Mpixel");
    }
    @And("Adds them to compare List")
    public void adds_them_to_compare_list() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://demowebshop.tricentis.com/hard-drive-handycam-camcorder");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/input")).click();

        driver.get("https://demowebshop.tricentis.com/camcorder");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/input")).click();

        driver.get("https://demowebshop.tricentis.com/digital-slr-camera");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[5]/input")).click();
    }
    @Then("Site should show a compare List")
    public void site_should_show_a_compare_list() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[1]/h1")));

        driver.close();
    }
}
