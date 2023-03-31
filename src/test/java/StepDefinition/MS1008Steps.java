package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MS1008Steps {
    WebDriver driver;
    @Given("user is on website demoqatoolresizable")
    public void user_is_on_website_demoqatoolresizable() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/resizable");
    }
    @When("he rizes a frame")
    public void he_rizes_a_frame() throws InterruptedException {
        WebElement box = driver.findElement(By.id("resizableBoxWithRestriction"));

        // Get the current size of the box
        Dimension boxSize = box.getSize();

        // Create a new Actions object to perform the resize
        Actions builder = new Actions(driver);

        // Move the mouse to the bottom right corner of the box
        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span"))).clickAndHold();

        // Move the mouse to the new size of the box
        builder.moveByOffset(300, 250);

        // Release the mouse button
        builder.release();

        // Perform the resize action
        builder.perform();

        Thread.sleep(2000);

        // Quit the driver
        driver.quit();
    }
    @Then("frame is resized")
    public void frame_is_resized() {

    }
}
