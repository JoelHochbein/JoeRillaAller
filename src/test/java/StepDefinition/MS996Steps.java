package StepDefinition;

import Pages.DQApractiseform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MS996Steps {
    WebDriver driver;

    @Given("user is on website dqa")
    public void user_is_on_website_dqa() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/select-menu");
    }
    @When("he selects something from every dropdownbar")
    public void he_selects_something_from_every_dropdownbar() throws InterruptedException {

        WebElement selectvalue2 = driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
        Select dropdown2 = new Select(selectvalue2);
        dropdown2.selectByValue("4");

        driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div/div[1]")).sendKeys("Group 1");

        Thread.sleep(1000);
        Select drpValue = new Select(driver.findElement(By.xpath("//div[contains(text(),'Select Option')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Select Option')]")).click();
        Thread.sleep(1000);
        drpValue.selectByValue("Group 1, option 2");
    }
    @Then("selected data should be present in the bar")
    public void selected_data_should_be_present_in_the_bar() {

    }
}
