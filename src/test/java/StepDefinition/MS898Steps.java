package StepDefinition;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MS898Steps {
    WebDriver driver;

    @Given("admin has his browser opened")
    public void admin_has_his_browser_opened() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }
    @When("he opens the url")
    public void he_opens_the_url() {
        driver.get("https://demowebshop.tricentis.com/");
    }
    @Then("a list of all links are shown in the console")
    public void a_list_of_all_links_are_shown_in_the_console() {
          List<WebElement> linksListe = driver.findElements(By.tagName("a"));

          for(WebElement link : linksListe) {
              System.out.println(link.getAttribute("href"));
          }
          driver.close();
    }
}
