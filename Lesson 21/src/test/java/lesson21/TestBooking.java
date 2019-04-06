package lesson21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBooking {
	private WebDriver driver;	
	private BookingPage bookingPage;
	
	private static final String url = "https://www.booking.com";
	

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		bookingPage = new BookingPage(driver);	
		driver.manage().window().maximize();
		bookingPage.open(url);	
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@Test(priority = 1)
	public void testHotelsExisting() {				
		bookingPage.calendar();
		bookingPage.arrivalDate();
		bookingPage.departureDate();
		bookingPage.searchByCity("Moscow");		
		Assert.assertTrue(bookingPage.getHotelList().size() > 0, "There are not hotels");
	}
	
	@Test(priority = 2)
	public void testCheckHotellsOnRaiting() {		
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
		Assert.assertTrue(bookingPage.getHotelRating() >= 9.0, "Hotel is not rated ");
	}

}
