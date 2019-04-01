package core;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HW19_3 {
	@Test
	public void testBooking() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");

		driver.findElement(
				By.xpath("(//*[@class='bk-icon -experiments-calendar sb-date-picker_icon-svg'])[1]"))
				.click();

		WebElement dateWidgetFrom = driver.findElement(By
				.xpath("(//*[@class='bui-calendar__dates'])[1]"));
		List<WebElement> columnsFrom = dateWidgetFrom.findElements(By
				.tagName("td"));

		String from = getFromDate();
		for (WebElement cell : columnsFrom) {
			String text = cell.getText();
			if (text.equals(from)) {
				System.out.println(from);
				cell.click();
				break;
			}
		}

		WebElement dateWidgetTo = driver.findElement(By
				.xpath("(//*[@class='bui-calendar__dates'])[2]"));
		List<WebElement> columnsTo = dateWidgetTo
				.findElements(By.tagName("td"));

		String to = getToDate();
		System.out.println(to);
		for (WebElement cell : columnsTo) {
			String text = cell.getText();
			if (text.equals(to)) {
				System.out.println(to);
				cell.click();
				break;
			}
		}

		// Wait for 4 Seconds to see all dates selected.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement searchField = driver.findElement(By
				.xpath("//*[@type='search']"));
		searchField.sendKeys(new String[] { "Paris" });
		searchField.submit();

		WebElement checkbox = driver
				.findElement(By
						.xpath("//*[@class='bui-checkbox__label filter_item css-checkbox']"));
		checkbox.click();

		List<WebElement> hotels = driver.findElements(By
				.xpath(".//img[@class='hotel_image']"));
		Assert.assertFalse(hotels.isEmpty());

		WebElement sortByRating = driver.findElement(By
				.xpath("//*[@class=' sort_category   sort_class_and_price ']"));
		sortByRating.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement hotel = driver
				.findElement(By
						.xpath("//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[1]/div[1]/h3/a/span[1]"));
		hotel.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		Select roomsDropdown = new Select(
				driver.findElement(By
						.xpath("//*[@id=\"hprt-form\"]/table/tbody/tr[1]/td[5]/div/label/select")));

		roomsDropdown.selectByIndex(1);

		WebElement reserveButton = driver.findElement(By
				.xpath("//*[@id=\"hp_book_now_button\"]/span[1]"));
		reserveButton.click();

		WebElement emailField = driver.findElement(By
				.xpath("//*[@id=\"email\"]"));
		emailField.sendKeys("sambuk@tut.by");

		WebElement emailConfirmedField = driver.findElement(By
				.xpath("//*[@id=\"email_confirm\"]"));
		emailConfirmedField.sendKeys("sambuk@tut.by");

		WebElement lastNameField = driver.findElement(By
				.xpath("//*[@id=\"lastname\"]"));
		lastNameField.sendKeys("Sambuk");
		lastNameField.sendKeys(Keys.ENTER);

		WebElement phone = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		phone.sendKeys("297777777");

		Select cardType = new Select(driver.findElement(By
				.xpath("//*[@id=\"cc_type\"]")));
		cardType.selectByIndex(1);

		WebElement cardNumber = driver.findElement(By
				.xpath("//*[@id=\"cc_number\"]"));
		cardNumber.sendKeys("4242 4242 4242");

		WebElement cvcNumber = driver.findElement(By
				.xpath("//*[@id=\"cc_cvc\"]"));
		cvcNumber.sendKeys("555");

		Select year = new Select(driver.findElement(By
				.xpath("//*[@id=\"ccYear\"]")));
		year.selectByIndex(5);

		cvcNumber.sendKeys(Keys.ENTER);

		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Text not found!",
				bodyText.contains("Please fill in a valid card number"));
		driver.quit();

	}

	private String getFromDate() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.add(Calendar.DATE, 23);
		int from = calendar.get(Calendar.DAY_OF_MONTH);
		return String.valueOf(from);
	}

	private String getToDate() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.add(Calendar.DATE, 1);
		int to = calendar.get(Calendar.DAY_OF_MONTH);
		return String.valueOf(to);
	}
}