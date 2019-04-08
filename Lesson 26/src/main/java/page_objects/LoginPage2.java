package page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage2 {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(xpath = "(//div[contains(@class,'checkbox__box') and ancestor::div[@id='b-letters']and not(ancestor::div[contains(@style, 'display: none;')])])")
	public List<WebElement> checkboxList;

	public LoginPage2(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 45, 500);
		PageFactory.initElements(driver, this);
	}

	public WebDriver setPropertyWindow() {
		driver.manage().window().maximize();
		return driver;
	}

	public void login(String url, String login, String password) {
		driver.get(url);
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		passwordField.submit();
		wait.until(ExpectedConditions.visibilityOfAllElements(checkboxList));
	}
}
