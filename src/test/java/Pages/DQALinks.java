package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DQALinks {
    private static WebElement element = null;
    public static WebElement created(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='created']"));
        return element;
    }
    public static WebElement nocontent(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='no-content']"));
        return element;
    }
    public static WebElement moved(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='moved']"));
        return element;
    }
    public static WebElement badrequest(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='bad-request']"));
        return element;
    }
    public static WebElement unauthorized(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='unauthorized']"));
        return element;
    }
    public static WebElement forbidden(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='forbidden']"));
        return element;
    }
    public static WebElement notfound(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='invalid-url']"));
        return element;
    }
}
