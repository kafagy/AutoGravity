package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy(xpath="//h2[text()=\"How AutoGravity Works\"]")
    WebElement homePagetitle;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle()
    {
        return homePagetitle.getText();
    }

    public void noSingIn()
    {
        driver.findElement(By.xpath("//button[text()=\"Get Started\"]")).click();
    }
}
