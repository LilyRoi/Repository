package junitcucumber;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps

{
	private static final String URL = "https://www.booking.com";	
	private BookingPage bookingPage;
	private WebDriver webDriver;

	public BookingSteps() {

		webDriver = new ChromeDriver();
		bookingPage = new BookingPage(webDriver);
	}

	@Given("^I am on main booking page$")
	public void loadMainPage() {
		webDriver.get(URL);
		webDriver.manage().window().maximize();
	}

	@When("^I select dates and search by Moscow$")
	public void selectDatesAndSearch() {
		bookingPage.calendar();
		bookingPage.arrivalDate();
		bookingPage.departureDate();
		bookingPage.searchByCity("Moscow");
	}

	@Then("I see there are hotels for required dates")
	public void checkHotelsList() {
		Assert.assertTrue(bookingPage.getHotelList().size() > 0);
	}

	@When("^I select dates and search by Moscow and sort by rating and get first hotel$")
	public void selectDatesAndSearchAndSort() {
		bookingPage.calendar();
		bookingPage.arrivalDate();
		bookingPage.departureDate();
		bookingPage.searchByCity("Moscow");
		bookingPage.sortRaiting();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bookingPage.getHotelList().get(0).click();
	}

	@Then("I see that rating >=9")
	public void checkHotelRaiting() {
		Assert.assertTrue(bookingPage.getHotelRating() >= 9.0);
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}

}
