package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Employment
{
    WebDriver driver;
    WebDriverWait wait;

    public Employment(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void EmploymentStatus(String status) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        driver.findElements(By.xpath("//button[@type=\"button\"]")).get(0).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//div[text()=\"" + status + "\"]")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    public void EmployerName(String name) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("employer-name")).sendKeys(name);
    }

    public void EmployeeTitle(String title) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("employee-title"));
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(title);
        actions.build().perform();
    }

    public void EmployeeStartDate(String start) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("employee-start-date")).sendKeys(start);
    }

    public void EmployerPhoneNumber(String phone) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("employer-phone-number")).sendKeys(phone);
    }

    public void GrossMonthlyIncome(String income) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("gross-monthly-income")).sendKeys(income);
    }

    public void Navigate() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.xpath("//button[text()=\"Next\"]")).click();
    }
}
