package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Booking2case {
	@Test
	public void testBooking() {
		String exePath = "C:\\Users\\sama\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");

		WebElement searchField = driver.findElement(By.xpath("//*[@id='ss']"));
		searchField.sendKeys(new String[] { "Москва" });
		searchField.submit();

		WebElement date = driver
				.findElement(By
						.xpath("//*[@id='frm']/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[6]/span"));
		date.click();

		WebElement search = driver.findElement(By
				.xpath("//*[@id='frm']/div[5]/div[2]/button/span[1]"));
		search.click();

		WebElement expand = driver.findElement(By
				.xpath("//*[@id='sortbar_dropdown_button']"));
		expand.click();

		WebElement sortByMaxRating = driver.findElement(By
				.xpath("//*[@id='sortbar_dropdown_options']/li/a"));
		sortByMaxRating.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement clickFirstItem = driver.findElement(By
				.xpath("//a[@class='hotel_name_link url']"));
		clickFirstItem.click();

		WebElement raiting = driver.findElement(By
				.xpath("//div[@class='bui-review-score__badge']"));
		Double actualRaiting = Double.parseDouble(raiting.getText());
		System.out.println("actualRaiting = " + actualRaiting);
		Assert.assertTrue("Actual raiting is less then 9", 9.0 <= actualRaiting);
		driver.quit();

	}
}