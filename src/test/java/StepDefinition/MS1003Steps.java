package StepDefinition;

import Pages.DQAWebTable;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MS1003Steps {
    WebDriver driver;
    Faker faker = new Faker();
    @Given("user is on website demoqawebtables")
    public void user_is_on_website_demoqawebtables() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/webtables");
    }
    @When("he adds a user")
    public void he_adds_a_user() {
        DQAWebTable.addbtn(driver).click();
        DQAWebTable.frstname(driver).sendKeys(faker.name().firstName());
        DQAWebTable.lsltname(driver).sendKeys(faker.name().lastName());
        DQAWebTable.mailadress(driver).sendKeys(faker.name().firstName()+faker.name().lastName()+faker.number().digits(3)+"@mail.com");
        DQAWebTable.age(driver).sendKeys(faker.number().digits(2));
        DQAWebTable.salary(driver).sendKeys(faker.number().digits(4));
        DQAWebTable.department(driver).sendKeys(faker.address().buildingNumber());
        DQAWebTable.submitbtn(driver).click();
    }
    @Then("user should appear in the webtable")
    public void user_should_appear_in_the_webtable() {
        driver.close();
    }
}
