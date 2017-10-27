package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.*;

public class ExistingUser
{
    WebDriver driver;
    WebDriverWait wait;

    Login objLogin;
    HomePage objHomePage;
    Car objCar;
    Payments objPayment;
    Dealership objDealership;
    LoginPersonal objPersonal;
    Residence objResidence;
    Employment objEmployment;

    @BeforeTest
    public void setup()
    {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        driver.get("https://www-staging.autogravity.com/");
    }

    @Test(priority=0)
    public void test_homepage()
    {
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getTitle().contains("AutoGravity"));
    }

    @Test(priority=1)
    public void test_login()
    {
        objLogin = new Login(driver);
        objLogin.navigateLogin();
        Assert.assertTrue(objLogin.getLoginTitle().contains("Log In To Your AutoGravity Account"));
        objLogin.login("batman@gustr.com", "123QWEasd");
        Assert.assertTrue(objLogin.getTitleAfterLogin().contains("Select Make"));
    }

    @Test(priority=2)
    public void test_car() throws InterruptedException
    {
        objCar = new Car(driver, wait);
        objCar.Make("Aston Martin");
        objCar.Model("Vanquish");
        objCar.MyLocation();
        objCar.CarProperty("S Coupe");
    }

    @Test(priority=3)
    public void test_payments() throws InterruptedException
    {
        objPayment = new Payments(driver, wait);
        objPayment.TradeIn("NO");
        objPayment.DownPayment("50000");
        objPayment.NumberOfMonths("84");
        objPayment.Navigate();
    }

    @Test(priority=4)
    public void test_dealership() throws InterruptedException
    {
        objDealership = new Dealership(driver, wait);
        objDealership.DealerLocation();
    }

    @Test(priority=5)
    public void test_personal() throws InterruptedException
    {
        objPersonal = new LoginPersonal(driver);
        objPersonal.setFirstName("Bruce");
        objPersonal.setLastName("Wayne");
        objPersonal.setDob("05/27/1938");
        objPersonal.setPhone("735-185-7301");
        objPersonal.clickNext();
    }

    @Test(priority=6)
    public void test_residence() throws InterruptedException
    {
        objResidence = new Residence(driver, wait);
        objResidence.ResidenceStatus("Own");
        objResidence.Address("Batcave");
        objResidence.City("Gotham");
        objResidence.State("New Jersey");
        objResidence.Zipcode("12345");
        objResidence.MoveInDate("05/1939");
        objResidence.MortgagePayment("0");
        objResidence.Navigate();
    }

    @Test(priority=7)
    public void test_employment() throws InterruptedException
    {
        objEmployment = new Employment(driver);
        objEmployment.EmploymentStatus("Full Time");
        objEmployment.EmployerName("Jim Gorden");
        objEmployment.EmployeeTitle("Batman");
        objEmployment.EmployeeStartDate("05/2011");
        objEmployment.EmployerPhoneNumber("714-278-9999");
        objEmployment.GrossMonthlyIncome("10000000");
        objEmployment.Navigate();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
