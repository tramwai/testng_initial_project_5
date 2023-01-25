package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormCardPage;
import utilities.TestData;


public class TechGlobalLoginFormCardTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormCardPage = new TechGlobalLoginFormCardPage();

    }

    /**
    Test Case 1: Validate TechGlobal Login Form card
     Given user is on https://techglobal-training.netlify.app/
     When user clicks on "Practices" dropdown in the header
     And user select the "Frontend Testing" option
     And user clicks on the "Login Form" card
     Then user should see heading1 as “Login Form”
     And user should see “Please enter your username” label and username input box
     And user should see “Please enter your password” label and password input box
     And user should see “LOGIN” button
     And user should see “Forgot Password?” link
     */
    @Test(priority = 1, description = "Validate TechGlobal Login Form card")
    public void validateLoginFormCard() {

        // user should see heading1 as “Login Form”
        Assert.assertTrue(techGlobalLoginFormCardPage.header.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormCardPage.header.getText(), TestData.loginForm);

        // user should see “Please enter your username” label and username input box
        Assert.assertEquals(techGlobalLoginFormCardPage.usernameLabel.getText(), TestData.enterUsername);

        //user should see “Please enter your password” label and password input box
        Assert.assertEquals(techGlobalLoginFormCardPage.passwordLabel.getText(), TestData.enterPassword);

        // user should see “LOGIN” button
        Assert.assertTrue(techGlobalLoginFormCardPage.loginButton.isDisplayed());

        // user should see “Forgot Password?” link
        Assert.assertTrue(techGlobalLoginFormCardPage.forgotPasswordLink.isDisplayed());
    }

    /**
     Test Case 2: Validate TechGlobal Login card valid login
     Given user is on https://techglobal-training.netlify.app/
     When user clicks on "Practices" dropdown in the header
     And user select the "Frontend Testing" option
     And user clicks on the "Login" card
     And user enters username as “TechGlobal” and password as “Test1234”
     And user clicks on “LOGIN” button
     Then user should see “You are logged in” message
     And user should see “LOGOUT” button
     */

    @Test(priority = 2, description = "Validate TechGlobal Login card valid login")
    public void validateLoginValidCredentials(){

        // user enters username as “TechGlobal” and password as “Test1234”
        techGlobalLoginFormCardPage.usernameInput.sendKeys(TestData.validUsername);
        techGlobalLoginFormCardPage.passwordInput.sendKeys(TestData.validPassword);

        // user clicks on the "Login" card
        techGlobalLoginFormCardPage.loginButton.click();

        // user should see “You are logged in” message
        Assert.assertTrue(techGlobalLoginFormCardPage.messageAfterSuccessfulLogin.isDisplayed());

        // And user should see “LOGOUT” button
        Assert.assertTrue(techGlobalLoginFormCardPage.logoutButton.isDisplayed());

        }


        /**
        Test Case 3: Validate TechGlobal Login card valid login and then logout
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login" card
        And user enters username as “TechGlobal” and password as “Test1234”
        And user clicks on “LOGIN” button
        And user clicks on “LOGOUT” button
        Then user should be navigated back to Login Form
         */

        @Test(priority = 3, description = "Validate TechGlobal Login card valid login and then logout")
        public void validateLoginValidCredentialsAndLogout(){

            // login with valid credentials
            validateLoginValidCredentials();

            // user clicks on “LOGOUT” button
            Assert.assertTrue(techGlobalLoginFormCardPage.logoutButton.isEnabled());
            techGlobalLoginFormCardPage.logoutButton.click();

            // user should be navigated back to Login Form
           // Assert.assertEquals(driver.getCurrentUrl(), TestData.loginFormURL); // URL on this site does not change
            Assert.assertTrue(techGlobalLoginFormCardPage.loginButton.isDisplayed());
        }

        /**
        Test Case 4: Validate TechGlobal Login card Forgot Password? Link and Reset Password page
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login" card
        And user clicks on “Forgot Password?” link
        Then user should see “Reset Password” heading1
        And user should see “Enter your email address and we'll send you a link to reset your password.” message
        And user should see email input box
        And user should see “SUBMIT” button
         */

        @Test(priority = 4, description = "Validate TechGlobal Login card Forgot Password? Link and Reset Password page")
    public void validateForgotPasswordLink(){

            // And user clicks on “Forgot Password?” link
            techGlobalLoginFormCardPage.forgotPasswordLink.click();

            // Then user should see “Reset Password” heading1
            techGlobalLoginFormCardPage.resetPasswordHeading.isDisplayed();

            // user should see “Enter your email address and we'll send you a link to reset your password.” message
            techGlobalLoginFormCardPage.resetPasswordEmailMessage.isDisplayed();

            // user should see email input box
            techGlobalLoginFormCardPage.resetPasswordEmailInputBox.isDisplayed();

            // user should see “SUBMIT” button
            techGlobalLoginFormCardPage.resetPasswordSubmitButton.isDisplayed();

        }

        /**
        Test Case 5: Validate TechGlobal Login card Reset Password link
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login" card
        And user clicks on “Forgot Password?” link
        When user enters a valid email to email input box
        And user clicks on “SUBMIT” button
        Then user should see “A link to reset your password has been sent to your email address.” message
         */

        @Test(priority = 5, description = "Validate TechGlobal Login card Reset Password link")
        public void validateResetPasswordLink(){

            // user clicks on “Forgot Password?” link
            techGlobalLoginFormCardPage.forgotPasswordLink.click();

            // user enters a valid email to email input box
            techGlobalLoginFormCardPage.resetPasswordEmailInputBox.sendKeys(TestData.validEmail);

            // user clicks on “SUBMIT” button
            techGlobalLoginFormCardPage.resetPasswordSubmitButton.click();

            // user should see “A link to reset your password has been sent to your email address.” message
            Assert.assertEquals(techGlobalLoginFormCardPage.resetPasswordEmailMessageAfterSubmit.getText(), TestData.linkToResetPasswordMessage);
        }

        /**
        Test Case 6: Validate TechGlobal Login card invalid login with wrong username
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login" card
        And user enters username as “john” and password as “Test1234”
        And user clicks on “LOGIN” button
        Then user should see “Invalid Username entered!” message
         */

        @Test(priority = 6, description = "Validate TechGlobal Login card invalid login with wrong username")
        public void validateInvalidLoginWrongUsername(){

            // user enters username as “john” and password as “Test1234”
            techGlobalLoginFormCardPage.usernameInput.sendKeys(TestData.invalidUsername);
            techGlobalLoginFormCardPage.passwordInput.sendKeys(TestData.validPassword);

            // user clicks on “LOGIN” button
            techGlobalLoginFormCardPage.loginButton.click();

            // user should see “Invalid Username entered!” message
            Assert.assertEquals(techGlobalLoginFormCardPage.InvalidUsernameErrorMessage.getText(), TestData.invalidUsernameMessage);

        }


        /**
        Test Case 7: Validate TechGlobal Login card invalid login with wrong password
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login" card
        And user enters username as “TechGlobal” and password as “1234”
        And user clicks on “LOGIN” button
        Then user should see “Invalid Password entered!” message
         */

        @Test(priority = 7, description = "Validate TechGlobal Login card invalid login with wrong password")
    public void validateInvalidLoginWrongPassword(){

            // user enters username as “TechGlobal” and password as “1234”
            techGlobalLoginFormCardPage.usernameInput.sendKeys(TestData.validUsername);
            techGlobalLoginFormCardPage.passwordInput.sendKeys(TestData.invalidPassword);

            // user clicks on “LOGIN” button
            techGlobalLoginFormCardPage.loginButton.click();

            // user should see “Invalid Password entered!” message
            Assert.assertEquals(techGlobalLoginFormCardPage.InvalidPasswordErrorMessage.getText(), TestData.invalidPasswordMessage);

        }

        /**
        Test Case 8: Validate TechGlobal Login card invalid login with both wrong credentials
         Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login" card
        And user enters username as “john” and password as “1234”
        And user clicks on “LOGIN” button
        Then user should see “Invalid Username entered!” message
         */

        @Test(priority = 8, description = "Validate TechGlobal Login card invalid login with both wrong credentials")
    public void validateLoginWrongUsernameAndPassword(){

            //  user enters username as “john” and password as “1234”
            techGlobalLoginFormCardPage.usernameInput.sendKeys(TestData.invalidUsername);
            techGlobalLoginFormCardPage.passwordInput.sendKeys(TestData.invalidPassword);

            // user clicks on “LOGIN” button
            techGlobalLoginFormCardPage.loginButton.click();

            // user should see “Invalid Username entered!” message
            Assert.assertEquals(techGlobalLoginFormCardPage.InvalidUsernameErrorMessage.getText(), TestData.invalidUsernameMessage);

        }
    }




















