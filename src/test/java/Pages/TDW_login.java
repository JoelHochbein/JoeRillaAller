package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TDW_login {
    private static WebElement element = null;
    public static WebElement email_textbox(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        return element;
    }

    public static WebElement password_textbox(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        return element;
    }

    public static WebElement log_in_button(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        return element;
    }

}
