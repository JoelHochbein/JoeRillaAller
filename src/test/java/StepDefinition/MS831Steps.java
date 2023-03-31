package StepDefinition;

import io.cucumber.java.en.And;
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

public class MS831Steps {
    WebDriver driver;
    @Given("user openes the website")
    public void user_openes_the_website() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
    }
    @When("he adds at least {int} articles to his shopping cart")
    public void he_adds_at_least_articles_to_his_shopping_cart(Integer int1) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://demowebshop.tricentis.com/smartphone");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-43\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p")));

        driver.get("https://demowebshop.tricentis.com/blue-jeans");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-36\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p")));

        driver.get("https://demowebshop.tricentis.com/computing-and-internet");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-13\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p")));
    }
    @And("he clicks on shopping cart")
    public void he_clicks_on_shopping_cart() {

        driver.get("https://demowebshop.tricentis.com/cart");
    }
    @Then("the user receives a {string} price that corresponds to the sum of all articles")
    public void the_user_receives_a_price_that_corresponds_to_the_sum_of_all_articles(String string) {

        WebElement preis1Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[6]/span[2]"));
        String preis1Text = preis1Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis1Price = Double.parseDouble(preis1Text)/100.0;

        WebElement preis2Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[6]/span[2]"));
        String preis2Text = preis2Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis2Price = Double.parseDouble(preis2Text)/100.0;

        WebElement preis3Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[3]/td[6]/span[2]"));
        String preis3Text = preis3Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis3Price = Double.parseDouble(preis3Text)/100.0;

        WebElement totalpreis = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/span/span"));
        String totalpreistext = totalpreis.getText().replaceAll("[^0-9]", "");
        double totalpreispreis = Double.parseDouble(totalpreistext)/100.0;

        double gesamtpreis = (preis1Price + preis2Price + preis3Price); //alle artikel zusammengerechnet

        double differenz = (gesamtpreis - totalpreispreis);

        System.out.println("Total Preis: " + totalpreispreis +" Summe aller Artikel: "+gesamtpreis);

        if (differenz == 0) {
            System.out.println("Berechnung Richtig!");
        }
        else {
            System.out.println("Berechnung Falsch!");
        }

        driver.close();

    }
}
