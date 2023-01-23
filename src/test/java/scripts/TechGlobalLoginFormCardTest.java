package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormCardPage;


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
        Assert.assertEquals(techGlobalLoginFormCardPage.header.getText(), "Login Form");

        // user should see “Please enter your username” label and username input box
        Assert.assertEquals(techGlobalLoginFormCardPage.usernameLabel.getText(), "Please enter your username");

        //user should see “Please enter your password” label and password input box
        Assert.assertEquals(techGlobalLoginFormCardPage.passwordLabel.getText(), "Please enter your password");

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
        techGlobalLoginFormCardPage.usernameInput.sendKeys("TechGlobal");
        techGlobalLoginFormCardPage.passwordInput.sendKeys("Test1234");

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
            Assert.assertEquals(driver.getCurrentUrl(), "https://techglobal-training.netlify.app/frontend/login-form");

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



    }




















