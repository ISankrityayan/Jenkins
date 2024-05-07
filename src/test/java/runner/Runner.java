package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {
	        "src/test/java/features/AddToCart.feature",
	        "src/test/java/features/Login.feature",
	        "src/test/java/features/Sort.feature"
	    },
	    glue = "StepDefinition",
	    tags = "@AddToCart or @SignUpToAmazon or @SortProductsTest",
	    		 plugin = {"pretty","html:target/cucumberAmazon.html","json:target/cucumberAmazon.json"}
	)
	public class Runner {
	
	}
 
