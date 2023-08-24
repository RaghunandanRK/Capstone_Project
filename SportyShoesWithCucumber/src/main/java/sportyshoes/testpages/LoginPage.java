package sportyshoes.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class LoginPage {
	
    private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	
	@FindBy(id = "email")
	private WebElement emailBox;
	
	@FindBy(id = "password")
	private WebElement passwordBox;
	
    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary']")
    private WebElement loginButton;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    
    public void enterEmail(String email) {
        emailBox.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        passwordBox.sendKeys(password);
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }

}
