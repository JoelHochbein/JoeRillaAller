package StepDefinition;
import Pages.DQApractiseform;
import Pages.TDWHomePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;
import java.time.Duration;
import java.io.File;
public class MS919Steps {
    WebDriver driver;
    Faker faker = new Faker();

    @Given("user is on the website!")
    public void user_is_on_the_website_https_demoqa_com_automation_practice_form() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }
    @When("user fills the form")
    public void user_fills_the_form() throws InterruptedException {
        Random ran = new Random();
        int x = ran.nextInt(3) + 1;
        int y = ran.nextInt(3) + 1;

        DQApractiseform.firstname(driver).sendKeys(faker.name().firstName());
        DQApractiseform.lastname(driver).sendKeys(faker.name().lastName());

        Thread.sleep(2000);

        if (x == 1) {
            DQApractiseform.male(driver).click();
        }
        else if (x == 2) {
            DQApractiseform.female(driver).click();
        }
        else if (x == 3) {
            DQApractiseform.other(driver).click();
        }

        DQApractiseform.mail(driver).sendKeys(faker.name().firstName()+faker.name().lastName()+faker.number().digits(3)+"@mail.com");
        DQApractiseform.mobilenumber(driver).sendKeys("491"+faker.number().digits(7));
        //DQApractiseform.dateofbirth(driver).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", DQApractiseform.dateofbirth(driver));
        //driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).click();

        WebElement dropdownListmonth = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select select = new Select(dropdownListmonth);
        select.selectByVisibleText("January");

        WebElement dropdownListyear = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select select1 = new Select(dropdownListyear);
        select1.selectByVisibleText("1999");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", DQApractiseform.dateofbirthnumber(driver));
        //driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[4]")).click();

        Thread.sleep(2000);

        if (y == 1) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", DQApractiseform.sports(driver));
        }
        else if (y == 2) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", DQApractiseform.reading(driver));
        }
        else if (y == 3) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", DQApractiseform.music(driver));
        }

        WebElement fileInput = driver.findElement(By.id("uploadPicture"));

        String filePath = System.getProperty("user.dir") + "/submitdata/minion.jpg";
        fileInput.sendKeys(filePath);

        DQApractiseform.currentaddress(driver).sendKeys(faker.address().streetAddress() + " / " +faker.address().city());
    }
    @When("clicks on submit")
    public void clicks_on_submit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", DQApractiseform.submit(driver));
    }
    @Then("user gets a list of his submitted data")
    public void user_gets_a_list_of_his_submitted_data() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]")));
        System.out.println("List of submitted data is shown.");
        driver.close();
    }
}
