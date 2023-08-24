package sportyshoes.testpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
    private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	
	@FindBy(id = "name")
	private WebElement nameBox;
	
	@FindBy(id = "email")
	private WebElement emailBox;
	
	@FindBy(id = "password")
	private WebElement passwordBox;
	
    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary']")
    private WebElement registerButton;
    
    @FindBy(xpath = "//a[@class='nav-link' and @href='/logout']")
    private WebElement logoutLink;
	
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    
    public void enterName(String name) {
        nameBox.sendKeys(name);
    }
    
    public void enterEmail(String email) {
        emailBox.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        passwordBox.sendKeys(password);
    }
    
    public void clickRegisterButton() {
        registerButton.click();
    }
    
    public void clickLogoutLink() {
        logoutLink.click();
    }

}
