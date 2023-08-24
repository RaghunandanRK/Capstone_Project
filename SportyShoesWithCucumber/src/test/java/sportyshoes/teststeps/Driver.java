package sportyshoes.teststeps;

import org.openqa.selenium.edge.EdgeDriver;

import sportyshoes.testpages.AddToCartPage;
import sportyshoes.testpages.CartPage;
import sportyshoes.testpages.LandingPage;
import sportyshoes.testpages.LoginPage;
import sportyshoes.testpages.RegistrationPage;

public class Driver extends Tools {
	
	protected static LandingPage landingPage;
	protected static RegistrationPage registrationPage;
	protected static LoginPage loginPage;
	protected static AddToCartPage addToCartPage;
	protected static CartPage cartPage;
	
	public static void init() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9010/");
		landingPage = new LandingPage(driver);
		registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        addToCartPage = new AddToCartPage(driver);
        cartPage = new CartPage(driver);
	}

}
