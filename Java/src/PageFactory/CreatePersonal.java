package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreatePersonal
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="firstNameTextField")
    WebElement FirstName;

    @FindBy(id="lastNameTextField")
    WebElement LastName;

    @FindBy(id="dobTextField")
    WebElement Dob;

    @FindBy(id="mobilePhoneTextField")
    WebElement Phone;

    @FindBy(id="emailTextField")
    WebElement Email;

    @FindBy(id="passwordTextField")
    WebElement Password;

    @FindBy(id="confirmPasswordTextField")
    WebElement ConfirmPassword;

    @FindBy(xpath="//button[text()=\"Create and Continue\"]")
    WebElement NavCreate;

    @FindBy(xpath="//h1[text()=\"Select Make\"]")
    WebElement AfterLoginTitle;

    public CreatePersonal(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName)
    {
        FirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName)
    {
        LastName.sendKeys(lastName);
    }

    public void setDob(String dob)
    {
        Dob.sendKeys(dob);
    }

    public void setPhone(String phone)
    {
        Phone.sendKeys(phone);
    }

    public void setEmail(String email)
    {
        Email.sendKeys(email);
    }

    public void setPassword(String password)
    {
        Password.sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword)
    {
        ConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickCreate() throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Create and Continue\"]")));
        NavCreate.click();
    }
}
