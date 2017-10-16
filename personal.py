import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class Personal(object):
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 30)

    # Inputs First Name
    def FirstName(self, firstname):
        self.wait.until(EC.visibility_of_element_located((By.ID, 'firstNameTextField')))
        self.driver.find_element_by_id('firstNameTextField').send_keys(firstname)

    # Inputs Last Name
    def LastName(self, lastname):
        self.wait.until(EC.visibility_of_element_located((By.ID, 'lastNameTextField')))
        self.driver.find_element_by_id('lastNameTextField').send_keys(lastname)

    # Inputs Date of Birth
    def DOB(self, dob):
        self.wait.until(EC.visibility_of_element_located((By.ID, 'dobTextField')))
        self.driver.find_element_by_id('dobTextField').send_keys(dob)

    # Inputs Phone number
    def Phone(self, phone):
        self.wait.until(EC.visibility_of_element_located((By.ID, 'mobilePhoneTextField')))
        self.driver.find_element_by_id('mobilePhoneTextField').send_keys(phone)

    # Clicks on button "Next"
    def Navigate(self):
        time.sleep(2)
        self.driver.save_screenshot('Personal_Information.png')
        self.driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        self.wait.until(EC.element_to_be_clickable((By.XPATH, '//button[text()="Next"]')))
        self.driver.find_element_by_xpath('//button[text()="Next"]').click()






