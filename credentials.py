class Credentials(object):

    def __init__(self, driver):
        self.driver = driver

    def Username(self, user_name):
        self.driver.find_element_by_name('email').clear()
        self.driver.find_element_by_name('email').send_keys(user_name)

    def Password(self, password):
        self.driver.find_element_by_name('password').clear()
        self.driver.find_element_by_name('password').send_keys(password)

    def ConfirmPassword(self, confirm_password):
        self.driver.find_element_by_name('passwordConfirm').clear()
        self.driver.find_element_by_name('passwordConfirm').send_keys(confirm_password)

    def SignIn(self):
        self.driver.save_screenshot('SignIn.png')
        self.driver.find_element_by_xpath('//button[@class="btn btn-primary"]').click()
        #self.driver.find_element_by_xpath('//button[@type="button"][text()="Log In').click()

    def Create(self):
        self.driver.save_screenshot('SignUp.png')
        self.driver.find_element_by_xpath('//button[@class="btn btn-primary"]').click()
        #self.driver.find_element_by_xpath('//button[@type="button"][text()="Log In').click()
