package sportyshoes.testpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AddToCartPage {
    
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    
    @FindBy(css = "#mynavbar > ul > li:nth-child(3) > a")
    private WebElement profile;
    
    @FindBy(css = "#mynavbar > ul > li:nth-child(1) > a")
    private WebElement home;
    
    @FindBy(xpath = "//a[@href='add-to-cart?id=101' and @class='btn btn-primary']")
    private WebElement addToCartButton;
    
    @FindBy(css = "body > div:nth-child(3) > div > strong")
    private WebElement successMessage;
    
    @FindBy(xpath = "//a[@class='nav-link' and @href='/home']")
    private WebElement homeLink;
    
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    
    public void clickProfile() {
        profile.click();
    }
    
    public void clickHome() {
        home.click();
    }
    
    public void clickAddToCart() throws InterruptedException {
        scrollToElement(addToCartButton);
        
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
    
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
    
    public String getSuccessMessageText() {
        return successMessage.getText();
    }
    
    public void clickHomeLink() {
        homeLink.click();
    }
    
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    }
}
