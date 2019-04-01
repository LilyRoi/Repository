package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HW19_1 {
	@Test
	public void testBooking() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");

		driver.findElement(
				By.xpath("(//*[@class='bk-icon -experiments-calendar sb-date-picker_icon-svg'])[1]"))
				.click();

		WebElement dateWidgetFrom = driver.findElement(By
				.xpath("(//*[@class='bui-calendar__wrapper'])[1]"));
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
				.xpath("(//*[@class='bui-calendar__wrapper'])[2]"));
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

		WebElement price = driver
				.findElement(By
						.xpath("//*[@id='hotellist_inner']/div[2]/div[2]/div[2]/div/table/tbody/tr/td[2]/div/strong"));
		System.out.println(price.getText());
		String priceStr = price.getText().substring(4).replaceAll(",", "");
		int actualPrice = Integer.parseInt(priceStr);
		System.out.println(actualPrice);
		Assert.assertTrue(1000 < actualPrice);
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
