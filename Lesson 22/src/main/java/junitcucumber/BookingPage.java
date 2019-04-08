package junitcucumber;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage
{
	protected WebDriver driver;
	protected WebDriverWait wait;

	@FindBy(xpath = "//*[@id='ss']")
	private WebElement searchField;		
	
	@FindBy(xpath = "//span[@class='sb-submit-helper']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[@class='xp__dates-inner']")
	private WebElement calendar;
	
	@FindBy(xpath = "//*[@id=\"ss\"]")
	private WebElement searchCity;
	
	@FindBy(xpath = ".//td[@data-date=\"2019-04-10\"]")
	private WebElement arrivalDate;
	
	@FindBy(xpath = ".//td[@data-date=\"2019-04-20\"]")
	private WebElement departureDate;	
	
	@FindBy(xpath = ".//span[@class[contains(.,'sr-hotel__name')]]") 
	private List<WebElement> hotelsList;
	
	@FindBy(xpath = "//*[@id=\"filter_review\"]/div[2]/a[1]")
	private WebElement sortByRaiting;
	
	@FindBy(xpath = ".//div[@class='bui-review-score__badge']")
	private WebElement ratingHotel;

	public BookingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 45, 500);
		PageFactory.initElements(driver, this);
	}

	public WebDriver setPropertyWindow() {
		driver.manage().window().maximize();
		return driver;
	}
	
	public void open(String url) {
		driver.get(url);		
	}

	public void searchByCity(String city) {
		searchField.sendKeys(new String[] { city });
		searchField.submit();
	}	
	
	public void clickSearch() {
		searchButton.submit();
	}
	
	public void calendar() {
		calendar.click();
	}

	public void arrivalDate() {
		arrivalDate.click();
	}

	public void departureDate() {
		departureDate.click();
	}	
	
	public List<WebElement> getHotelList() {
		return hotelsList;
	}
	
	public void sortRaiting() {
		sortByRaiting.click();
	}
	
	public Double getHotelRating() {
		return Double.valueOf(ratingHotel.getText().replace(",","."));

	}
	
	
	
    /*private static final int LINK_PRESENSE_TIMEOUT = 10;

	private WebDriver driver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;

    public BookingPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }

    public void enterLoginAndPass(String login, String password)
    {
        loginField.clear();
        loginField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickEnterButton()
    {
        buttonEnter.click();
	}

	public boolean logoutLinkPresents() {
		return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT))
				.until(ExpectedConditions.visibilityOf(logoutLink))
				.isDisplayed();
	}

	public boolean logoutLinkErrorPresents() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLinkError)).isDisplayed();
	}*/
}
