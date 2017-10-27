package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPersonal
{
    WebDriver driver;

    @FindBy(id="firstNameTextField")
    WebElement FirstName;

    @FindBy(id="lastNameTextField")
    WebElement LastName;

    @FindBy(id="dobTextField")
    WebElement Dob;

    @FindBy(id="mobilePhoneTextField")
    WebElement Phone;

    @FindBy(xpath="//button[text()=\"Next\"]")
    WebElement Button;

    public LoginPersonal(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstname) throws InterruptedException
    {
        FirstName.sendKeys(firstname);
    }
    public void setLastName(String lastname) throws InterruptedException
    {
        LastName.sendKeys(lastname);
    }
    public void setDob(String dob) throws InterruptedException
    {
        Dob.sendKeys(dob);
    }
    public void setPhone(String phone) throws InterruptedException
    {
        Phone.sendKeys(phone);
    }
    public void clickNext() throws InterruptedException
    {
        Button.click();
    }

}
