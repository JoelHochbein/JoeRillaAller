package StepDefinition;

import Pages.TDWHomePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS909Steps {
    double proof = 2000.0;
    WebDriver driver;
    Faker faker = new Faker();
    @Given("user opens the website {string}")
    public void user_opens_the_website(String string) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
    }
    @When("User customizes a expensive computer")
    public void user_customizes_a_expensive_computer() {
        driver.get("https://demowebshop.tricentis.com/build-your-own-expensive-computer-2");
        TDWHomePage.processorfast(driver).click();
        TDWHomePage.ram8gb(driver).click();
        TDWHomePage.hdd400gb(driver).click();


    }
    @And("Adds it to the Shopping cart.")
    public void adds_it_to_the_shopping_cart() throws InterruptedException {
        TDWHomePage.atcexpensivecomputer(driver).click();
        Thread.sleep(2000);
    }
    @And("Switches to Shopping cart")
    public void switches_to_shopping_cart() {
        driver.get("https://demowebshop.tricentis.com/cart");
    }
    @Then("Computer should show up in Shopping cart")
    public void computer_should_show_up_in_shopping_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(TDWHomePage.expensivecomputerproof(driver)));
    }
    @And("cost more then twothousand dollar")
    public void cost_more_then_twothousand_dollar() {
        WebElement preis1Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[6]/span[2]"));
        String preis1Text = preis1Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis1Price = Double.parseDouble(preis1Text)/100.0;

        if (proof < preis1Price) {
            System.out.println("Der Computer kostet mehr als 2000$");
        }
        else {
            System.out.println("Der Computer kostet nicht mehr als 2000$");
        }
        driver.close();

        String password = faker.number().digits(4) + faker.name().lastName();
        String email = faker.name().firstName() + faker.name().lastName() + faker.number().digits(2) + "@mail.com"; //Testdaten-Generator
        System.out.println("Mail: " +email +"PWD: "+password);

        System.out.println("PROOF: "+proof +"tatsächlicher preis: " +preis1Price);
    }
}
