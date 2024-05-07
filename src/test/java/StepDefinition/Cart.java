package StepDefinition;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import resources.Hooks;

public class Cart {
	 WebDriver driver;
	    HomePage homePage;
	    CartPage cartPage;
	    ProductPage productPage;

	    @Given("^User is a guest user$")
	    public void user_is_a_guest_user() {
	        driver = Hooks.getDriver();
	        homePage = new HomePage(driver);
	        cartPage = new CartPage(driver);
	    }

	    @When("^User enters the \"(.*)\"$")
	    public void user_enters_the(String keyword) {
	        homePage.searchBox().sendKeys(keyword);
	        homePage.search().click();
	    }

	    @Then("^User adds the product to cart$")
	    public void user_adds_the_product_to_cart() throws InterruptedException {
	        productPage = new ProductPage(driver);

	        if (homePage.Pcard().isDisplayed()) {
	            homePage.Pcard().click();
	            String mainWindowHandle = driver.getWindowHandle();
	            Set<String> allWindowHandles = driver.getWindowHandles();
	            for (String handle : allWindowHandles) {
	                if (!handle.equals(mainWindowHandle)) {
	                    driver.switchTo().window(handle);
	                    break;
	                }
	            }
	            if (productPage.breadCrumb().isDisplayed()) {
	                productPage.addToCart().click();
	                Assert.assertEquals(productPage.successStatus().getText(), "Added to Cart");
	            }
	        }
	    }

	    @Then("^user updates the quantity$")
	    public void user_updates_the_quantity() {
	        CartPage cartPage = new CartPage(driver);
	        cartPage.shoppingCat().click();
	        if(cartPage.cart().isDisplayed())
	        {
	        	 Select quantity = new Select(cartPage.qty());
	 	        quantity.selectByValue("2");

	        	
	        }

	       	    }

	   
	  }
