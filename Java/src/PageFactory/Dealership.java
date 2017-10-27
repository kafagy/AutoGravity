package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Dealership
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//button[text()=\"Select this Dealer\"]")
    WebElement DealerLocation;

    public Dealership(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void DealerLocation() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Select this Dealer\"]")));
        DealerLocation.click();
    }
}
