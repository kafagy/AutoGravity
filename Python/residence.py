import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class Residence(object):
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 30)

    # Selects recidence status from dropdown
    def ResidenceStatus(self, status):
        self.driver.find_elements_by_xpath('//button[@type="button"]')[0].click()
        #self.driver.find_element_by_css_selector('#agselecthouseinfo > div:nth-child(1) > button').click()
        time.sleep(2)
        self.driver.find_element_by_xpath('//div[text()="' + status + '"]').click()
        time.sleep(2)

    # Inputs Address
    def Address(self, address):
        self.wait.until(EC.visibility_of_element_located((By.ID, 'aginputaddress')))
        self.driver.find_element_by_id('aginputaddress').send_keys(address)

    # Inputs City
    def City(self, city):
        self.driver.find_element_by_id('aginputcity').send_keys(city)

    # Inputs State
    def State(self, state):
        time.sleep(2)
        self.driver.find_elements_by_xpath('//button[@type="button"]')[1].click()
        #self.driver.find_element_by_css_selector('#agselectstate > div:nth-child(1) > button').click()
        time.sleep(2)
        self.driver.find_element_by_xpath('//div[text()="' + state + '"]').click()

    # Inputs Zipcode
    def Zipcode(self, zipcode):
        time.sleep(2)
        self.wait.until(EC.visibility_of_element_located((By.ID, 'aginputzip')))
        self.driver.find_element_by_id('aginputzip').send_keys(zipcode)

    # Inputs Move in date
    def MoveInDate(self, move_in_date):
        self.driver.find_element_by_id('aginputmoveindate').send_keys(move_in_date)

    # Inputs Mortgage Payment
    def MortgagePayment(self, mortgage_payment):
        self.driver.find_element_by_id('aginputpayment').send_keys(mortgage_payment)

    # Clicks on button "Next"
    def Navigate(self):
        self.driver.save_screenshot('Residence_Information.png')
        time.sleep(2)
        self.driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        self.wait.until(EC.element_to_be_clickable((By.XPATH, '//button[text()="Next"]')))
        self.driver.find_element_by_xpath('//button[text()="Next"]').click()

