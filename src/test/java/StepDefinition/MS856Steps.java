package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS856Steps {

    WebDriver driver;
    @Given("user has at least one product in the shopping cart2")
    public void user_has_at_least_one_product_in_the_shopping_cart2() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);

        driver.get("https://demowebshop.tricentis.com/apparel-shoes");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p")));

        driver.get("https://demowebshop.tricentis.com/cart");
    }
    @Given("user has given valid credit card informations")
    public void user_has_given_valid_credit_card_informations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]")).sendKeys("max");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]")).sendKeys("musterman");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]")).sendKeys("max@mail.com");

        WebElement ddowncountry = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")); //Dropdown Auswahl Land
        Select select = new Select(ddowncountry);
        select.selectByValue("35");

        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]")).sendKeys("maxtown");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]")).sendKeys("maxstreet");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")));

        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")));
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentmethod_2\"]")));
        driver.findElement(By.xpath("//*[@id=\"paymentmethod_2\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")));

        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CardholderName\"]")));

        driver.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys("Max Musterman");
        driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys("4111111111111111");

        driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
    }
    @When("user clicks on purchase")
    public void user_clicks_on_purchase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")));
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
    }
    @Then("user gets the message that the purchase was successful")
    public void user_gets_the_message_that_the_purchase_was_successful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")));
        System.out.println("Purchase was successful!");
    }
    @And("receives a order number")
    public void receives_a_order_number() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")));

        WebElement numberElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]"));
        String ordernumber = numberElement.getText();

        System.out.println(ordernumber);
        driver.quit();
    }

    //Negativ Scenario
    @Given("user has at least one product in the shopping cart3")
    public void user_has_at_least_one_product_in_the_shopping_cart3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);

        driver.get("https://demowebshop.tricentis.com/apparel-shoes");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p")));

        driver.get("https://demowebshop.tricentis.com/cart");
    }
    @Given("user has given invalid credit card informations")
    public void user_has_given_invalid_credit_card_informations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]")).sendKeys("max");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]")).sendKeys("musterman");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]")).sendKeys("max@mail.com");

        WebElement ddowncountry = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")); //Dropdown Auswahl Land
        Select select = new Select(ddowncountry);
        select.selectByValue("35");

        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]")).sendKeys("maxtown");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]")).sendKeys("maxstreet");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")));

        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")));
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentmethod_2\"]")));
        driver.findElement(By.xpath("//*[@id=\"paymentmethod_2\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")));

        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CardholderName\"]")));

        driver.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys("Max Musterman");
        driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys("4111116231111");

        driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys("1244");

    }
    @When("user clicks on purchase1")
    public void user_clicks_on_purchase1() {
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
    }
    @Then("user gets the message that he has to give valid credit card informations")
    public void user_gets_the_message_that_he_has_to_give_valid_credit_card_informations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-payment-info-load\"]/div/div/div[2]/div/ul/li")));
        driver.close();
    }
    @Then("user shouldnt be able to purchase")
    public void user_shouldnt_be_able_to_purchase() {
        System.out.println("User isnt able to purchase with invalid credit card information!");
    }
}
