package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DQAWebTable {
    private static WebElement element = null;

    public static WebElement addbtn(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]"));
        return element;
    }
    public static WebElement frstname(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        return element;
    }
    public static WebElement lsltname(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        return element;
    }
    public static WebElement mailadress(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        return element;
    }
    public static WebElement age(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        return element;
    }
    public static WebElement salary(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        return element;
    }
    public static WebElement department(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        return element;
    }
    public static WebElement submitbtn(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        return element;
    }
}
