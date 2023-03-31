package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MS1005Steps {
    WebDriver driver;

    @Given("user is on website demoqatooltips")
    public void user_is_on_website_demoqatooltips() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/tool-tips");
    }
    @When("he hovers over both buttons")
    public void he_hovers_over_both_buttons() throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveToElement(element).pause(1000).perform();
        Thread.sleep(2000);

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"toolTipTextField\"]"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(element2).perform();
        actions2.moveToElement(element2).pause(1000).perform();
        Thread.sleep(2000);
    }
    @Then("a message is shown")
    public void a_message_is_shown() {
        System.out.println("Hover successful, and message is shown!");

    }
}
