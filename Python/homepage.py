class Homepage(object):

    def __init__(self, driver):
        self.driver = driver

    def SignIn(self):
        self.driver.find_element_by_xpath('//a[text()="Log In"]').click()

    def SignUp(self):
        self.driver.find_element_by_xpath('//a[text()="Sign Up"]').click()
        self.driver.find_element_by_xpath('//button[text()="NEXT"]').click()
