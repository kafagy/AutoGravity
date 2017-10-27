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

public class CreateUser
{
    WebDriver driver;
    WebDriverWait wait;

    CreatePersonal objCreate;
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
        objHomePage.noSingIn();
    }

    @Test(priority=1)
    public void test_car() throws InterruptedException
    {
        objCar = new Car(driver, wait);
        objCar.Make("Aston Martin");
        objCar.Model("Vanquish");
        objCar.MyLocation();
        objCar.CarProperty("S Coupe");
    }

    @Test(priority=2)
    public void test_payments() throws InterruptedException
    {
        objPayment = new Payments(driver, wait);
        objPayment.TradeIn("NO");
        objPayment.DownPayment("50000");
        objPayment.NumberOfMonths("84");
        objPayment.Navigate();
    }

    @Test(priority=3)
    public void test_dealership() throws InterruptedException
    {
        objDealership = new Dealership(driver, wait);
        objDealership.DealerLocation();
    }

    @Test(priority=4)
    public void test_create() throws InterruptedException {
        objCreate = new CreatePersonal(driver, wait);
        objCreate.setEmail("batman234@gustr.com");
        objCreate.setFirstName("alibaba");
        objCreate.setLastName("babaali");
        objCreate.setDob("01/01/1995");
        objCreate.setPhone("7147282000");
        objCreate.setPassword("123QWEasd");
        objCreate.setConfirmPassword("123QWEasd");
        objCreate.clickCreate();
    }

    @Test(priority=5)
    public void test_residence() throws InterruptedException
    {
        objResidence = new Residence(driver, wait);
        objResidence.ResidenceStatus("Own");
        objResidence.Address("Batcave");
        objResidence.City("Gotham");
        objResidence.State("New Jersey");
        objResidence.Zipcode("12345");
        objResidence.MoveInDate("05/1996");
        objResidence.MortgagePayment("0");
        objResidence.Navigate();
    }

    @Test(priority=6)
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
