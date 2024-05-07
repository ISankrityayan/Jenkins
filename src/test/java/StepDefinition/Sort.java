package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import resources.Hooks;

public class Sort {
	WebDriver driver;
	HomePage sortPage;
	
	 @Given("^User is on the homepage of the application$")
	    public void user_is_on_the_homepage_of_the_application() {
		 driver = Hooks.getDriver();
sortPage = new HomePage(driver);
	       
	    }

	    @When("^User searches for \"([^\"]*)\"$")
	    public void user_searches_for(String keyword) throws InterruptedException {
	        sortPage.searchBox().sendKeys(keyword);
	        Thread.sleep(5000);
	        sortPage.search().click();;
	    }

	    @Then("^User verifies that products are sorted by price from low to high$")
	    public void user_verifies_that_products_are_sorted_by_price_from_low_to_high() throws InterruptedException {
	    	if(sortPage.tops().isDisplayed())
	    	{
	    		sortPage.featureBut().click();
	    		sortPage.lth().click();
	    		Thread.sleep(5000);
		        Assert.assertTrue(sortPage.lthbutton().isDisplayed());
	    	}
	    	
	    }
    
    
	
	    }



