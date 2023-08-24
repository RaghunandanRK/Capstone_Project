package sportyshoes.testpages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    JavascriptExecutor js;
    
    @FindBy(css = "#mynavbar > ul > li:nth-child(1) > a")
    private WebElement cartLink;
    
    @FindBy(css = "//a[@href='place-order' and contains(@class, 'btn btn-primary')]")
    private WebElement placeOrderButton;
    
    @FindBy(css = "body > div:nth-child(3) > div > strong")
    private WebElement successMessage;
    
    public CartPage(WebDriver driver) {
    	js=(JavascriptExecutor)driver;
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    
    public void clickCartLink() {
        cartLink.click();
    }
    
    @FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[1]")
	private WebElement placeOrderBtn;
	
	public void clickPlaceOrderButton() throws InterruptedException 
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView()",placeOrderBtn);
		js.executeScript("arguments[0].click()",placeOrderBtn);
	}
	
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
    
    public String getSuccessMessageText() {
        return successMessage.getText();
    }
    
}
