import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class Payments(object):
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 30)

    # Answers Yes or No for Trade-ins
    def TradeIn(self, decision):
        if decision.lower() == 'yes':
            self.wait.until(EC.visibility_of_element_located((By.XPATH, '//button[text()="Yes"]')))
            self.driver.find_element_by_xpath('//button[text()="Yes"]').click()
        elif decision.lower() == 'no':
            self.wait.until(EC.visibility_of_element_located((By.XPATH, '//button[text()="No"]')))
            self.driver.find_element_by_xpath('//button[text()="No"]').click()

    # Inputs the down payment for the car
    def DownPayment(self, amount):
        self.driver.find_element_by_xpath('//*[@id="downpaymentinput"]').clear()
        self.driver.find_element_by_xpath('//*[@id="downpaymentinput"]').send_keys(amount)

    # Chooses the number of months from the dropdown
    def NumberOfMonths(self, number):
        self.driver.find_element_by_xpath('//button[@type="button"]').click()
        time.sleep(2)
        self.driver.find_element_by_xpath('//div[text()="' + number + ' Months"]').click()

    # Clicks on button "Next"
    def Navigate(self):
        self.driver.save_screenshot('Payments_Information.png')
        time.sleep(2)
        self.driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        self.wait.until(EC.visibility_of_element_located((By.XPATH, '//button[text()="NEXT"]')))
        self.driver.find_element_by_xpath('//button[text()="NEXT"]').click()



