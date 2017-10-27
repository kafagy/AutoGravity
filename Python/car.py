import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class Car(object):
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 30)

    # Chooses a car brand
    def Make(self, make):
        self.wait.until(EC.visibility_of_element_located((By.XPATH, '//img[@title="' + make + '"]')))
        self.driver.find_element_by_xpath('//img[@title="' + make + '"]').click()

    # Chooses the car's Model
    def Model(self, model):
        self.wait.until(EC.visibility_of_element_located((By.XPATH, '//h5[text()="' + model + '"]')))
        self.driver.find_element_by_xpath('//h5[text()="' + model + '"]').click()

    # Lets Google Chrome use your current location for the geolocation service built-in
    def MyLocation(self):
        time.sleep(2)
        self.wait.until(EC.visibility_of_element_located((By.XPATH, '//button[@class="blueButton___3S9-a fullWidth___3UKHr geoButton___1PU6W"]')))
        self.driver.find_element_by_xpath('//button[@class="blueButton___3S9-a fullWidth___3UKHr geoButton___1PU6W"]').click()

    # Chooses car properties
    def CarProperty(self, property):
        self.driver.save_screenshot('Car.png')
        self.wait.until(EC.visibility_of_element_located((By.XPATH, '//div[text()="' + property + '"]')))
        self.driver.find_element_by_xpath('//div[text()="' + property + '"]').click()
