package StepDefinition;

import Pages.TDWHomePage;
import Pages.TDW_register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS917Steps {
    WebDriver driver;//*[@id="bar-notification"]/p

    @Given("User adds five different articles in the shopping cart")
    public void user_adds_five_different_articles_in_the_shopping_cart() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-cookies");
        driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://demowebshop.tricentis.com/computing-and-internet");
        TDWHomePage.computingandinternetatc(driver).click();
        Thread.sleep(1000);

        driver.get("https://demowebshop.tricentis.com/blue-jeans");
        TDWHomePage.bluejeansatcbtn(driver).click();
        Thread.sleep(1000);

        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        TDWHomePage.buildyourowncheapcomputeratcbtn(driver).click();
        Thread.sleep(1000);

        driver.get("https://demowebshop.tricentis.com/fiction");
        TDWHomePage.fictionatcbtn(driver).click();
        Thread.sleep(1000);

        driver.get("https://demowebshop.tricentis.com/health");
        TDWHomePage.healthbookatcbtn(driver).click();
        Thread.sleep(1000);

    }
    @When("User clicks on shopping cart")
    public void user_clicks_on_shopping_cart() {
        TDWHomePage.shoppingcart(driver).click();

    }
    @Then("The sum of all individual items corresponds to the total price")
    public void the_sum_of_all_individual_items_corresponds_to_the_total_price() {
        WebElement preis1Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[6]/span[2]"));
        String preis1Text = preis1Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis1Price = Double.parseDouble(preis1Text)/100.0;

        WebElement preis2Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[6]/span[2]"));
        String preis2Text = preis2Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis2Price = Double.parseDouble(preis2Text)/100.0;

        WebElement preis3Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[3]/td[6]/span[2]"));
        String preis3Text = preis3Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis3Price = Double.parseDouble(preis3Text)/100.0;

        WebElement preis4Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[4]/td[6]/span[2]"));
        String preis4Text = preis4Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis4Price = Double.parseDouble(preis4Text)/100.0;

        WebElement preis5Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[5]/td[6]/span[2]"));
        String preis5Text = preis5Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis5Price = Double.parseDouble(preis5Text)/100.0;

        WebElement totalpreis = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/span/span"));
        String totalpreistext = totalpreis.getText().replaceAll("[^0-9]", "");
        double totalpreispreis = Double.parseDouble(totalpreistext)/100.0;

        double sumallarticles = preis1Price + preis2Price + preis3Price + preis4Price + preis5Price;
        double difference = totalpreispreis - sumallarticles;

        if (difference == 0) {
            System.out.println("Berechnung des total Preises richtig!");
        }
        else {
            System.out.println("Berechnung des total Preises falsch!");
        }
        driver.close();
    }
}
