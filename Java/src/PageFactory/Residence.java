package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Residence
{
    WebDriver driver;
    WebDriverWait wait;

    public Residence(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void ResidenceStatus(String status) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type=\"button\"]"))).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//div[text()=\"" + status + "\"]")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    public void Address(String address) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aginputaddress")));
        driver.findElement(By.id("aginputaddress")).sendKeys(address);
    }

    public void City(String city) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aginputcity")));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("aginputcity"));
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(city);
        actions.build().perform();
    }

    public void State(String state) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        driver.findElements(By.xpath("//button[@type=\"button\"]")).get(1).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//div[text()=\"" + state + "\"]")).click();
    }

    public void Zipcode(String zipcode) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aginputzip")));
        driver.findElement(By.id("aginputzip")).sendKeys(zipcode);
    }

    public void MoveInDate(String move_in_date) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aginputmoveindate")));
        driver.findElement(By.id("aginputmoveindate")).sendKeys(move_in_date);
    }

    public void MortgagePayment(String mortgage_payment) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aginputpayment")));
        driver.findElement(By.id("aginputpayment")).sendKeys(mortgage_payment);
    }

    public void Navigate() throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        TimeUnit.SECONDS.sleep(8);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"NEXT\"]")));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

    }
}
