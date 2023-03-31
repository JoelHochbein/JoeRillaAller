package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TDWHomePage {

    private static WebElement element = null;
    public static WebElement textbox_search(WebDriver driver) {

        element = driver.findElement(By.name("q"));
        return element;
    }

    public static WebElement button_search(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]"));
        return element;
    }

    public static WebElement log_in(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        return element;
    }

    public static WebElement log_in_proof(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        return element;
    }

    public static WebElement TDWpng(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img"));
        return element;
    }
    public static WebElement register(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        return element;
    }
    public static WebElement addtocartbutton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-71\"]"));
        return element;
    }
    public static WebElement jewelry(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[1]/a/img"));
        return element;
    }
    public static WebElement lengthincm(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"product_attribute_71_10_16\"]"));
        return element;
    }
    public static WebElement shoppingcart(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
        return element;
    }
    public static WebElement shoppingcartproof(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1"));
        return element;
    }
    public static WebElement computersreiter(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
        return element;
    }
    public static WebElement processorfast(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"product_attribute_74_5_26_82\"]"));
        return element;
    }
    public static WebElement ram8gb(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"product_attribute_74_6_27_85\"]"));
        return element;
    }
    public static WebElement hdd400gb(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"product_attribute_74_3_28_87\"]"));
        return element;
    }
    public static WebElement atcexpensivecomputer(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-74\"]"));
        return element;
    }
    public static WebElement expensivecomputerproof(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[2]/img"));
        return element;
    }
    public static WebElement addtocartproof(WebDriver driver) {
        element = driver.findElement(By.className("content"));
        return element;
    }
    public static WebElement computingandinternetatc(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-13\"]"));
        return element;
    }
    public static WebElement bluejeansatcbtn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-36\"]"));
        return element;
    }
    public static WebElement buildyourowncheapcomputeratcbtn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-72\"]"));
        return element;
    }
    public static WebElement fictionatcbtn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-45\"]"));
        return element;
    }
    public static WebElement healthbookatcbtn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-22\"]"));
        return element;
    }
    public static WebElement atcproof(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p/a"));
        return element;
    }



}
