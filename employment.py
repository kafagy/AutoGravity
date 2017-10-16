import time
from selenium.webdriver.support.ui import WebDriverWait

class Employment(object):
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 30)

    # Selects employment status from dropdown
    def EmploymentStatus(self, status):
        time.sleep(2)
        self.driver.find_elements_by_xpath('//button[@type="button"]')[0].click()
        time.sleep(2)
        self.driver.find_element_by_xpath('//div[text()="' + status + '"]').click()
        time.sleep(2)

    # Inputs Employer Name
    def EmployerName(self, name):
        self.driver.find_element_by_id('employer-name').send_keys(name)

    # Inputs Employee Title
    def EmployeeTitle(self, title):
        self.driver.find_element_by_id('employee-title').send_keys(title)

    # Inputs Employee Start Date
    def EmployeeStartDate(self, start):
        self.driver.find_element_by_id('employee-start-date').send_keys(start)

    # Inputs Employer Phone Number
    def EmployerPhoneNumber(self, phone):
        self.driver.find_element_by_id('employer-phone-number').send_keys(phone)

    # Inputs Gross Monthly Income
    def GrossMonthlyIncome(self, income):
        self.driver.find_element_by_id('gross-monthly-income').send_keys(income)

    # Clicks on button "Next"
    def Navigate(self):
        time.sleep(3)
        self.driver.save_screenshot('Employtment_Information.png')
        self.driver.find_element_by_xpath('//button[text()="Next"]').click()
        self.driver.save_screenshot('Stopping_Point.png')

