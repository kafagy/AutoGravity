import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class Dealership(object):
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 30)

    # Make the browser use the current location
    def MyLocation(self):
        time.sleep(2)
        self.driver.save_screenshot('Dealership_Location.png')
        self.wait.until(EC.visibility_of_element_located((By.XPATH, '//button[text()="Select this Dealer"]')))
        self.driver.find_elements_by_xpath('//button[text()="Select this Dealer"]')[0].click()
        #self.driver.find_element_by_xpath('//button[@class="btn btn-primary dealerSelectBtn___8r46A"]').click()
