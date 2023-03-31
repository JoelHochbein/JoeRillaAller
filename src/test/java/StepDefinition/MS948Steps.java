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

import java.awt.*;

public class MS948Steps {
    WebDriver driver;
    @Given("user is on website.")
    public void user_is_on_website() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/slider");
    }
    @When("he slides the slider until")
    public void he_slides_the_slider_until() {
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 100, 0).perform();
    }
    @Then("value in textbox should be")
    public void value_in_textbox_should_be() {

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/div/div[1]"));
        String sliderValue = slider.getText();

        System.out.println("slider value: "+slider);
        driver.close();
    }
}
