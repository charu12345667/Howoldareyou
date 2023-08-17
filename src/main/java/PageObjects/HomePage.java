package PageObjects;



import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DateUtils;
import Utilities.Wait;

public class HomePage {

	WebDriverWait wait;

	public HomePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		wait = Wait.setSimpleWait(webDriver, 30);

	}
	
	@FindBy(xpath = "//h1[@class='logo cursive']")
	private WebElement headerLogo;
	

	@FindBy(id = "inputName")
	private WebElement txtName;

	@FindBy(id = "inputBirthday")
	private WebElement txtDOB;

	@FindBy(id = "help_birthday")
	private WebElement msgDateError;

	@FindBy(id = "help_name")
	private WebElement msgNameError;

	@FindBy(id = "submitButton")
	private WebElement btnSubmit;

	@FindBy(id = "resultName")
	private WebElement lblName;

	@FindBy(id = "resultAge")
	private WebElement lblAge;
	
	
	public boolean isheaderDisplayed() {
		return headerLogo.isDisplayed();
	}
	

	public void sendInfo(String name, String dob) {
        
		
		txtName.sendKeys(name);
		txtDOB.sendKeys(dob);
		

	}
	
	public void clickSubmit() throws InterruptedException {
		
		btnSubmit.click();
		Thread.sleep(3000);
	}

	public boolean isNameErrorMessageDisplayed() {

		return msgNameError.isDisplayed();
	}

	public boolean isDateErrorMessageDisplayed() {

		return msgDateError.isDisplayed();
	}

	public String getNameInfo() {

		return "Hello " + lblName.getText() + "!";

	}

	public String getAgeInfo() {

		return "Your Age is " + lblAge.getText();

	}
	
	
	public void validateMessage(String DOB,String name) throws ParseException {
		
		if(DateUtils.diff(DOB, "years")==0) {
			
			if(DateUtils.diff(DOB, "days")>=0) {
				
				System.out.println("Actual result::"+getNameInfo() +" "+getAgeInfo());
				System.out.println("Expected result::"+"Hello " + name + "!" +" "+"Your Age is " +DateUtils.diff(DOB, "days"));
			}
			else {
				
				System.out.println("Error message for future date::"+msgDateError.getText());
			}
			
		}
		
		else if(DateUtils.diff(DOB, "years") > 0 && DateUtils.diff(DOB, "years") <=122 ) {
			
			System.out.println("Actual result::"+getNameInfo() +" "+getAgeInfo());
			System.out.println("Expected result::"+"Hello " + name + "!" +" "+"Your Age is " +DateUtils.diff(DOB, "years"));
		
		}
		
		else {
			
			System.out.println("Error message for too old ::"+msgDateError.getText());
		}
		
		
	}

}
