package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import resources.Hooks;

public class Login  {
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	
	@Given("I click on the sign in button")
    public void i_click_on_the_sign_in_button() {
		
		driver = Hooks.getDriver();
		 homePage=new HomePage(driver);
		 loginPage=new LoginPage(driver);

		homePage.signIn().click();
        
    }

    @Then("I should be navigated to the signin page")
    public void i_should_be_navigated_to_the_signin_page() {
       Assert.assertTrue(loginPage.sign().isDisplayed());
    }

    @When("I enter Username as {string}")
    public void i_enter_username_as(String username) {
    	 if(loginPage.sign().isDisplayed()) {
    		 loginPage.emailField().sendKeys(username);
    	 }
    }

    @When("click on continue button")
    public void click_on_continue_button() {
       loginPage.continueButton().click();
    }

    @Then("I should land on the {string} password page")
    public void i_should_land_on_the_password_page(String expected) throws InterruptedException {
         Thread.sleep(5000);
    	
    	 boolean isPasswordPageDisplayed = loginPage.password().isDisplayed();

    	    if (isPasswordPageDisplayed && expected.equals("success")) {
    	        System.out.println("Successfully landed on the password page.");
    	    } else if (!isPasswordPageDisplayed && expected.equals("fail")) {
    	        System.out.println("Successfully didn't land on the password page.");
    	    } else {
    	        
    	        System.out.println("Error: Expected landing on the password page does not match actual result.");
    	        Assert.fail("Expected landing on the password page does not match actual result.");
    	    }
    }
    
 
    }


