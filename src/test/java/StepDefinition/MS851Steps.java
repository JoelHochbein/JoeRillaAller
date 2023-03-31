package StepDefinition;

import io.cucumber.java.en.And;
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

public class MS851Steps {
    WebDriver driver;
    @Given("user has at least one product in the shopping cart")
    public void user_has_at_least_one_product_in_the_shopping_cart() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://demowebshop.tricentis.com/blue-jeans");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-36\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p")));

        driver.get("https://demowebshop.tricentis.com/cart");
    }
    @When("user chooses a product he wants to remove")
    public void user_chooses_a_product_he_wants_to_remove() {
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[5]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[5]/input")).sendKeys("0");
    }
    @And("clicks on update shopping cart")
    public void clicks_on_update_shopping_cart() {

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")).click();
    }
    @Then("product shouldnt be in the shopping cart anymore")
    public void product_shouldnt_be_in_the_shopping_cart_anymore() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[2]/div/div[1]/a/img"))); TEST
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[2]/div[2]/div")));
        System.out.println("Test erfolgreich!");
        driver.close();

    }
}
