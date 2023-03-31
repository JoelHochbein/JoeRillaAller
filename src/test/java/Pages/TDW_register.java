package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TDW_register {
    private static WebElement element = null;
    public static WebElement male(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
        return element;
    }

    public static WebElement female(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
        return element;
    }

    public static WebElement firstname(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
        return element;
    }
    public static WebElement lastname(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
        return element;
    }
    public static WebElement email(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        return element;
    }
    public static WebElement password(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        return element;
    }
    public static WebElement confirmpassword(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]"));
        return element;
    }
    public static WebElement registerbtn(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"register-button\"]"));
        return element;
    }
    public static WebElement registercontinue(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input"));
        return element;
    }
    public static WebElement registerproof(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]"));
        return element;
    }
}
