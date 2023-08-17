package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;

import PageObjects.HomePage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("Home page is displayed")
	public void home_page_is_displayed() {

		assertTrue(homePage.isheaderDisplayed(), "Is header logo displayed");
	}

	@When("Input credentials to Name {string} and Date of birth {string}")
	public void input_credentials_to_name_and_date_of_birth(String name, String dob) {

		homePage.sendInfo(name, dob);
		
	}

	@And("Click submit button")
	public void click_submit_button() throws InterruptedException {

		homePage.clickSubmit();
	}
	
	@Then("user should be able view message according to the  {string} and {string}")
	public void user_should_be_able_view_message_according_to_the_and(String name, String dob) throws ParseException {
		homePage.validateMessage(dob, name);
	}

	

}
