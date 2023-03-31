package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DQApractiseform {
    private static WebElement element = null;
    public static WebElement firstname(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        return element;
    }
    public static WebElement lastname(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        return element;
    }
    public static WebElement mail(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        return element;
    }
    public static WebElement male(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        return element;
    }
    public static WebElement female(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
        return element;
    }
    public static WebElement other(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label"));
        return element;
    }
    public static WebElement mobilenumber(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"userNumber\"]"));
        return element;
    }
    public static WebElement dateofbirth(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        return element;
    }
    public static WebElement dateofbirthnumber(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[4]"));
        return element;
    }
    public static WebElement subjects(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
        return element;
    }
    public static WebElement sports(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        return element;
    }
    public static WebElement reading(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"));
        return element;
    }
    public static WebElement music(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
        return element;
    }
    public static WebElement dateiauswählen(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]"));
        return element;
    }
    public static WebElement currentaddress(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        return element;
    }
    public static WebElement state(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"));
        return element;
    }
    public static WebElement city(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"stateCity-wrapper\"]/div[3]"));
        return element;
    }
    public static WebElement submit(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        return element;
    }
    public static WebElement clickme1(WebDriver driver) {

        element = driver.findElement(By.xpath("//button[@id='alertButton']"));
        return element;
    }
    public static WebElement clickme2(WebDriver driver) {

        element = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        return element;
    }
    public static WebElement clickme3(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"confirmButton\"]"));
        return element;
    }
    public static WebElement clickme4(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"promtButton\"]"));
        return element;
    }
    public static WebElement selectvalue(WebDriver driver) {

        element = driver.findElement(By.xpath("//div[contains(@class,'css-1pahdxg-control')]//div[contains(@class,'css-1hwfws3')]"));
        return element;
    }
    public static WebElement selectone(WebDriver driver) {

        element = driver.findElement(By.xpath("//div[contains(@class,'css-1pahdxg-control')]//div[contains(@class,'css-1hwfws3')]"));
        return element;
    }
    public static WebElement oldstyleselect(WebDriver driver) {

        element = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        return element;
    }
    public static WebElement multiselectdropdown(WebDriver driver) {

        element = driver.findElement(By.xpath("//div[@class=' css-1pahdxg-control']//div[@class=' css-1hwfws3']"));
        return element;
    }
    public static WebElement standardmultiselect(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"cars\"]"));
        return element;
    }
}
