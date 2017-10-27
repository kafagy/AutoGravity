package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
    WebDriver driver;

    @FindBy(name="email")
    WebElement Email;

    @FindBy(xpath="//a[text()=\"Log In\"]")
    WebElement NavLogin;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(xpath="//div[text()=\"Log In To Your AutoGravity Account\"]")
    WebElement Title;

    @FindBy(xpath="//button[@class=\"btn btn-primary\"][@type=\"submit\"]")
    WebElement Button;

    @FindBy(xpath="//h1[text()=\"Select Make\"]")
    WebElement AfterLoginTitle;

    public Login(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateLogin()
    {
        NavLogin.click();
    }

    public void setUserName(String strUserName)
    {
        Email.sendKeys(strUserName);
    }

    public void setPassword(String strPassword)
    {
        Password.sendKeys(strPassword);
    }

    public void clickLogin()
    {
        Button.click();
    }

    public String getLoginTitle()
    {
        return Title.getText();
    }

    public String getTitleAfterLogin()
    {
        return AfterLoginTitle.getText();
    }

    public void login(String strUserName, String strPasword)
    {
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();
    }
}
