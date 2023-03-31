package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DQALogin {
    private static WebElement element = null;
    public static WebElement username(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        return element;
    }
    public static WebElement passwort(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='password']"));
        return element;
    }
    public static WebElement login(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        return element;
    }
    public static WebElement validproof(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
        return element;
    }
    public static WebElement invalidproof(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
        return element;
    }


}
