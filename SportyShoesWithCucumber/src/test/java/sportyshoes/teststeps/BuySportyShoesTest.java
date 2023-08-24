package sportyshoes.teststeps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuySportyShoesTest extends Driver {
	
	@Given("User is on the Landing page")
	public void user_is_on_the_landing_page() {
		landingPage.clickNewUser();
	}

	@When("User registers with valid credentials")
	public void user_registers_with_valid_credentials() {
        registrationPage.enterName("Superman");
        registrationPage.enterEmail("superman@gmail.com");
        registrationPage.enterPassword("123456");
        registrationPage.clickRegisterButton();
        registrationPage.clickLogoutLink();
	}

	@When("User logs in with registered email and password")
	public void user_logs_in_with_registered_email_and_password() {
        loginPage.enterEmail("superman@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
	}

	@When("User adds shoes to the cart")
	public void user_adds_shoes_to_the_cart() throws InterruptedException {
        addToCartPage.clickProfile();
        addToCartPage.clickHome();
        addToCartPage.clickAddToCart();
	}

	@Then("Success message is displayed after adding to cart")
	public void success_message_is_displayed_after_adding_to_cart() {
        assertTrue(addToCartPage.isSuccessMessageDisplayed(), "Success message is not displayed.");
        assertEquals(addToCartPage.getSuccessMessageText(), "Success!");
        addToCartPage.clickHomeLink();
	}

	@Then("User goes to the cart and places an order")
	public void user_goes_to_the_cart_and_places_an_order() throws InterruptedException {
        cartPage.clickCartLink();
        cartPage.clickPlaceOrderButton();
	}

	@Then("Success message is displayed after placing an order")
	public void success_message_is_displayed_after_placing_an_order() {
        assertTrue(addToCartPage.isSuccessMessageDisplayed(), "Success message is not displayed.");
        assertEquals(addToCartPage.getSuccessMessageText(), "Success!");
	}


}
