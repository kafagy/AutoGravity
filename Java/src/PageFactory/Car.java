package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Car
{
    WebDriver driver;
    WebDriverWait wait;

    public Car(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
    }

    public void Make(String make) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title=\"" + make + "\"]")));
        driver.findElement(By.xpath("//img[@title=\"" + make + "\"]")).click();
    }

    public void Model(String model) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=\"" + model + "\"]")));
        driver.findElement(By.xpath("//h5[text()=\"" + model + "\"]")).click();
    }

    public void MyLocation() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(6);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"USE MY LOCATION\"]")));
        //driver.findElement(By.xpath("//button[text()=\"USE MY LOCATION\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"USE MY LOCATION\"]")).click();
    }

    public void CarProperty(String property)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"" + property + "\"]")));
        driver.findElement(By.xpath("//div[text()=\"" + property + "\"]")).click();
    }
}
