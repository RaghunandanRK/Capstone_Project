package sportyshoes.teststeps;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import sportyshoes.testpages.AddToCartPage;
import sportyshoes.testpages.CartPage;
import sportyshoes.testpages.LandingPage;
import sportyshoes.testpages.LoginPage;
import sportyshoes.testpages.RegistrationPage;


public class BuySportyShoesTest extends BaseTest {
	
	@Test
	public void buyShoes() throws InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver); 
		landingPage.clickNewUser();
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterName("Superman");
        registrationPage.enterEmail("superman@gmail.com");
        registrationPage.enterPassword("123456");
        registrationPage.clickRegisterButton();
        registrationPage.clickLogoutLink();
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("superman@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.clickProfile();
        addToCartPage.clickHome();
        addToCartPage.clickAddToCart();
        
        assertTrue(addToCartPage.isSuccessMessageDisplayed(), "Success message is not displayed.");
        assertEquals(addToCartPage.getSuccessMessageText(), "Success!");
        
        addToCartPage.clickHomeLink();
        
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartLink();
        cartPage.clickPlaceOrderButton();
        
        assertTrue(addToCartPage.isSuccessMessageDisplayed(), "Success message is not displayed.");
        assertEquals(addToCartPage.getSuccessMessageText(), "Success!");
	}

}
