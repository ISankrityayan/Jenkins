package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	public WebDriver driver;
	public LoginPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//h1[contains(text(), 'Sign in')]\r\n"
			+ "")
	WebElement sign;
	 
	 @FindBy(id="ap_email")
		WebElement emailField;
		
		@FindBy(xpath="//span[@id='continue' and contains(@class, 'a-button')]")
		WebElement continueButton;
		
		@FindBy(xpath="//input[@id=\"ap_password\"]")
		WebElement password;
		

		

		public WebElement sign() {
			return  sign;
		}
		
	
		public WebElement emailField() {
			return  emailField;
		}
		

		public WebElement continueButton() {
			return continueButton;
		}
		public WebElement password() {
			return  password;
		}
		

}
