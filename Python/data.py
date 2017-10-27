from car import Car
from payments import Payments
from personal import Personal
from residence import Residence
from dealership import Dealership
from employment import Employment
from credentials import Credentials

class Data(object):
    def __init__(self, driver):
        self.driver = driver

    def User(self):

        login = Credentials(self.driver)
        car = Car(self.driver)
        dealership = Dealership(self.driver)
        payments = Payments(self.driver)
        residence = Residence(self.driver)
        personal = Personal(self.driver)
        employement = Employment(self.driver)

        login.Username('batman@gustr.com')
        login.Password('123QWEasd')
        login.SignIn()

        car.Make('Aston Martin')
        car.Model('Vanquish')
        car.MyLocation()
        car.CarProperty('S Coupe')

        payments.TradeIn('NO')
        payments.DownPayment('50000')
        payments.NumberOfMonths('84')
        payments.Navigate()

        dealership.MyLocation()

        personal.FirstName('Bruce')
        personal.LastName('Wayne')
        personal.DOB('05/27/1938')
        personal.Phone('735-185-7301')
        personal.Navigate()

        residence.ResidenceStatus('Own')
        residence.Address('Batcave')
        residence.City('Gotham')
        residence.State('New Jersey')
        residence.Zipcode('12345')
        residence.MoveInDate('05/1939')
        residence.MortgagePayment('0')
        residence.Navigate()

        employement.EmploymentStatus('Full Time')
        employement.EmployerName('Jim Gorden')
        employement.EmployeeTitle('Batman')
        employement.EmployeeStartDate('05/2011')
        employement.EmployerPhoneNumber('714-278-9999')
        employement.GrossMonthlyIncome('10000000')
        employement.Navigate()

