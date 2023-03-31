package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS1009Steps {
    WebDriver driver;

    @Given("user is on website demoqadroppable")
    public void user_is_on_website_demoqadroppable() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/droppable");
    }
    @When("he drags the box")
    public void he_drags_the_box() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"draggable\"]")));

        Actions builder = new Actions(driver);

        WebElement box = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        // Move the mouse to the bottom right corner of the box
        builder.moveToElement(box).clickAndHold();

        // Move the mouse to the new size of the box
        builder.moveByOffset(300, 31);

        // Release the mouse button
        builder.release();

        // Perform the resize action
        builder.perform();

        Thread.sleep(2000);
    }
    @When("drops it in the other box")
    public void drops_it_in_the_other_box() throws InterruptedException {
        Actions builder = new Actions(driver);

        WebElement box = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));

        builder.moveToElement(box).clickAndHold();

        // Move the mouse to the new size of the box
        builder.moveByOffset(300, 31);

        // Release the mouse button
        builder.release();

        // Perform the resize action
        builder.perform();

    }
    @Then("Drop Box shows message: Dropped!")
    public void drop_box_shows_message_dropped() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"droppable\"]/p")));
        driver.close();
    }
}
