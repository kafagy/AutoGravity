package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Payments
{
    WebDriver driver;
    WebDriverWait wait;

    public Payments(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void TradeIn(String decision)
    {
        if (decision.toLowerCase().equals("yes"))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Yes\"]")));
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
        }
        else
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"No\"]")));
            driver.findElement(By.xpath("//button[text()=\"No\"]")).click();
        }
    }

    public void DownPayment(String amount)
    {
        driver.findElement(By.xpath("//*[@id=\"downpaymentinput\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"downpaymentinput\"]")).sendKeys(amount);
    }

    public void NumberOfMonths(String number) throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//div[text()=\"" + number + " Months\"]")).click();
    }

    public void Navigate() throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"NEXT\"]")));
        driver.findElement(By.xpath("//button[text()=\"NEXT\"]")).click();
    }
}
