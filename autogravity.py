import unittest
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

from homepage import Homepage
from data import Data

class autogravity(unittest.TestCase):
    def setUp(self):
        self.chrome_options = Options()
        self.chrome_options.add_experimental_option('prefs', {'geolocation': True})
        self.driver = webdriver.Chrome(chrome_options=self.chrome_options)
        self.driver.implicitly_wait(30)
        self.driver.maximize_window()
        self.driver.get("https://www-staging.autogravity.com/")

    def test_ExisitngUser(self):
        driver = self.driver
        homepage = Homepage(driver)
        homepage.SignIn()
        data = Data(driver)
        data.User()

    #def test_CreateAccount(self):
    #    driver = self.driver
    #    homepage = Homepage(driver)
    #    homepage.SignUp()
    #    signup = Credentials(driver)
    #    signup.Username('agagaga@gustr.com')
    #    signup.Password('123QWEasd')
    #    signup.ConfirmPassword('123QWEasd')
    #    signup.Create()

    def tearDown(self):
        self.driver.close()

if __name__ == "__main__":
    suite = unittest.TestLoader().loadTestsFromTestCase(autogravity)
    unittest.TextTestRunner(verbosity=2).run(suite)
